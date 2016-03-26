package HotelSearch.System;

import com.google.common.base.Defaults;
import org.jooq.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import org.jooq.impl.DSL;
import HotelSearch.Classes.SqlCustomQuery;
import static org.jooq.impl.DSL.*;

/**
 * Created by halldorr on 16/03/16.
 */
public class QueryStringBuilder {
    private static final Set<Class<?>> _primitiveTypes = getPrimitiveTypes();

    public static SqlCustomQuery getSQLQueryString(Object filter, String tableName) {
        DSLContext create = DSL.using(SQLDialect.MYSQL);
        SelectJoinStep queryString = create.select().from(tableName);

        Field[] fields = filter.getClass().getFields();
        SelectConditionStep step = queryString.where();

        for (Field f : fields) {
            try {
                Object o = f.get(filter);

                if (isPrimitiveType(f.getType())) {
                    if (o.equals(Defaults.defaultValue(f.getType()))) continue;
                    step = queryString.where(field(name(f.getName().toLowerCase())).equal(o));
                }
                if (isString(f.getType())) {
                    if (o == null) continue;
                    step = queryString.where(field(name(f.getName().toLowerCase())).likeIgnoreCase(o.toString()));
                }
            }
            catch (Exception e) { System.out.println("Error adding fields as conditions in QueryStringBuilder.GetQueryString"); }
        }
        SqlCustomQuery query = new SqlCustomQuery();
        query.sqlStatement = step.getSQL();
        query.values = step.getBindValues();
        return query;
    }

    private static boolean isString(Class<?> c) {
        return c == String.class;
    }

    private static boolean isPrimitiveType(Class<?> c) {
        return _primitiveTypes.contains(c);
    }

    private static Set<Class<?>> getPrimitiveTypes() {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(boolean.class);
        ret.add(double.class);
        ret.add(int.class);
        ret.add(long.class);
        ret.add(float.class);
        return ret;
    }


    public List<String> makeHotelQuery(List<String> input) {

        String area = input.get(0);
        String dateIn = input.get(1);
        String dateOut = input.get(2);

        if(area=="All areas")
            area = "IS NOT NULL" ;
        else
            area = "= '" + area + "'";

        dateIn = "'" + dateIn + "'";
        dateOut = "'" + dateOut + "'";


        String updateQuery = "DROP TABLE IF EXISTS tempReserved;\n" +
                "CREATE TEMPORARY TABLE tempReserved (\n" +
                "\thotel_id int,\n" +
                "\troom_number int );\n" +
                "INSERT INTO tempReserved\n" +
                "Select h.id, r.number\n" +
                "From Hotel h, Room r, Room_Type rt, Reservation res\n" +
                "Where res.hotel_id = h.id\n" +
                "and res.room_number = r.number\n" +
                "and rt.id = r.room_type_id\n" +
                "and ((res.date_in >= " + dateIn + " and res.date_out > " + dateOut + " and res.date_in < " + dateOut + ") \n" +
                "OR (res.date_in <= " + dateIn + " and res.date_out < " + dateOut + " and res.date_out > " + dateIn + " ) \n" +
                "OR (res.date_in <= " + dateIn + " and res.date_out > " + dateOut + ")\n" +
                "OR (res.date_in >= " + dateIn + " and res.date_out < " + dateOut + " ))\n"  +
                "and h.id = r.hotel_id;\n";

        System.out.println(updateQuery);

        String mainQuery =
                "Select h.*\n" +
                "From Hotel h, Location l, Room r, Room_Type rt\n" +
                "Where h.location_id = l.id\n" +
                "and rt.id = r.room_type_id\n" +
                "and h.id = r.hotel_id\n" +
                "and h.id NOT IN \n" +
                "\t(Select hotel_id from tempReserved)\n" +
                "and l.name " + area  + "\n" +
                "group by h.id;";

        List<String> sendList = new ArrayList<String>();
        sendList.add(mainQuery);
        sendList.add(updateQuery);
        return sendList;
    }
}

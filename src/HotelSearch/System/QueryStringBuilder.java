package HotelSearch.System;

import HotelSearch.Classes.QueryResolvers.IQueryResolver;
import com.google.common.base.Defaults;
import org.jooq.*;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import org.jooq.impl.DSL;
import HotelSearch.Classes.SqlCustomQuery;
import static org.jooq.impl.DSL.*;

/**
 * Created by halldorr on 16/03/16.
 */
public class QueryStringBuilder {

    String dateIn, dateOut;

    public List<String> makeSearchHotelsQuery(List<String> input) {

        String area = input.get(0);
        dateIn = input.get(1);
        dateOut = input.get(2);

        if(area=="All areas") area = "IS NOT NULL" ;
        else area = "= '" + area + "'";

        dateIn = "'" + dateIn + "'";
        dateOut = "'" + dateOut + "'";

        String updateQuery = "DROP TABLE IF EXISTS tmpBooked;\n" +
                "CREATE TEMPORARY TABLE tmpBooked (\n" +
                "\thotel_id int,\n" +
                "\troom_number int );\n" +
                "INSERT INTO tmpBooked\n" +
                "Select h.id, r.number\n" +
                "From Hotel h, Room r, Room_Type rt, Booking book\n" +
                "Where book.hotel_id = h.id\n" +
                "and book.room_number = r.number\n" +
                "and rt.id = r.room_type_id\n" +
                "and ((book.date_in >= " + dateIn + " and book.date_out >= " + dateOut + " and book.date_in < " + dateOut + ") \n" +
                "OR (book.date_in <= " + dateIn + " and book.date_out < " + dateOut + " and book.date_out > " + dateIn + " ) \n" +
                "OR (book.date_in <= " + dateIn + " and book.date_out > " + dateOut + ")\n" +
                "OR (book.date_in >= " + dateIn + " and book.date_out < " + dateOut + " ))\n"  +
                "and h.id = r.hotel_id;\n";

        String mainQuery =
                "Select h.*, a.name area_name \n" +
                "From Hotel h, Area a, Room r, Room_Type rt\n" +
                "Where h.area_id = a.id\n" +
                "and rt.id = r.room_type_id\n" +
                "and h.id = r.hotel_id\n" +
                "and h.id NOT IN \n" +
                "\t(Select hotel_id from tmpBooked)\n" +
                "and a.name " + area  + "\n" +
                "group by h.id;";

        return returnList(mainQuery,updateQuery);

    }

    public List<String> makeHotelInfoQuery(String hotel_id) {


        String updateQuery = "";

        String mainQuery =
                "Select h.*, a.name area_name, a.airport\n" +
                        "From Hotel h, Area a\n" +
                        "Where h.area_id = a.id\n" +
                        "and h.id = " + hotel_id;

        return returnList(mainQuery,updateQuery);

    }

    public List<String> makeHotelRoomsQuery(String hotel_id) {

        String updateQuery = "DROP TABLE IF EXISTS tmpRoomBooked;\n" +
                "CREATE TEMPORARY TABLE tmpRoomBooked (\n" +
                "\thotel_id int,\n" +
                "\troom_number int );\n" +
                "INSERT INTO tmpRoomBooked\n" +
                "Select h.id, r.number\n" +
                "From Hotel h, Room r, Room_Type rt, Booking book\n" +
                "Where book.hotel_id = h.id\n" +
                "and book.room_number = r.number\n" +
                "and rt.id = r.room_type_id\n" +
                "and ((book.date_in >= " + dateIn + " and book.date_out >= " + dateOut + " and book.date_in < " + dateOut + ") \n" +
                "OR (book.date_in <= " + dateIn + " and book.date_out < " + dateOut + " and book.date_out > " + dateIn + " ) \n" +
                "OR (book.date_in <= " + dateIn + " and book.date_out > " + dateOut + ")\n" +
                "OR (book.date_in >= " + dateIn + " and book.date_out < " + dateOut + " ))\n"  +
                "and h.id = " + hotel_id + ";";

        String mainQuery =
                "Select r.hotel_id, r.number , r.room_type_id, rt.name, rt.description, rt.max_capacaty, rt.price\n" +
                        "From Hotel h, Room r, Room_Type rt\n" +
                        "Where rt.id = r.room_type_id\n" +
                        "and h.id = r.hotel_id\n" +
                        "and concat(h.id,r.number) NOT IN \n" +
                        "\t(Select concat(hotel_id,room_number) from tmpRoomBooked)\n" +
                        "and h.id = " + hotel_id + ";";

        return returnList(mainQuery,updateQuery);
    }


    private  List<String> returnList(String a, String b) {
        List<String> sendList = new ArrayList<String>();
        sendList.add(a);
        sendList.add(b);
        return sendList;
    }



    public static SqlCustomQuery getSQLQueryString(Object filter, IQueryResolver resolver) {
        if (filter == null) throw new InvalidParameterException("Parameter filter can not be null");
        if (resolver == null) throw new InvalidParameterException("Parameter resolver can not be null");

        DSLContext create = DSL.using(SQLDialect.MYSQL);
        SelectJoinStep queryString = create.select().from(resolver.getTableName());

        Field[] fields = filter.getClass().getFields();
        SelectConditionStep step = queryString.where();

        for (Field f : fields) {
            try {
                Object o = f.get(filter);

                if (o == null) continue;
                else if (f.getType().isPrimitive())
                    if (o.equals(Defaults.defaultValue(f.getType()))) continue;


                if (resolver.equalCondition.contains(f))
                    step = queryString.where(field(name(f.getName().toLowerCase())).equal(o));
                else if (resolver.greaterEqualCondition.contains(f))
                    step = queryString.where(field(name(f.getName().toLowerCase())).greaterOrEqual(o));
                else if (resolver.lesserEqualCondition.contains(f))
                    step = queryString.where(field(name(f.getName().toLowerCase())).lessOrEqual(o));
            }
            catch (Exception e) { System.out.println("Error adding fields as conditions in QueryStringBuilder.GetQueryString"); }
        }
        SqlCustomQuery query = new SqlCustomQuery();
        query.sqlStatement = step.getSQL();
        query.values = step.getBindValues();
        return query;
    }

}

package HotelSearch.System;

import com.google.common.base.Defaults;
import org.jooq.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.table;
import static org.jooq.impl.DSL.value;

/**
 * Created by halldorr on 16/03/16.
 */
public class QueryStringBuilder {
    private static final Set<Class<?>> _primitiveTypes = getPrimitiveTypes();
    private boolean _whereUsed = false;

    public String GetQueryString(Object filter, String tableName) {
        DSLContext create = DSL.using(SQLDialect.MYSQL);
        SelectQuery queryString = create.selectQuery();

        List<Condition> conditionList = new ArrayList();

        Field[] fields = filter.getClass().getDeclaredFields();

        for (Field f : fields) {
            try {
                Object o = f.get(filter);
                if (isPrimitiveType(f.getType())) {
                    if (o.equals(Defaults.defaultValue(f.getType()))) continue;
//                    conditionList.add(table(tableName)
//                                        .field(f.getName().toLowerCase())
//                                        .equal());

                }
                if (isString(f.getType())) {
                    if (o == null) continue;
                    conditionList.add(table(tableName)
                                        .field(f.getName().toLowerCase())
                                        .likeIgnoreCase(o.toString()));
                }
            } catch (Exception e) { }
        }
        _whereUsed = false;
        queryString.addConditions(conditionList);
        return queryString.getSQL();
    }

    private boolean isString(Class<?> c) {
        return c == String.class;
    }

    private boolean isPrimitiveType(Class<?> c) {
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
}

package hotelsearch.System;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by halldorr on 16/03/16.
 */
public class QueryStringBuilder {
    private static final Set<Class<?>> _primitiveTypes = getPrimitiveTypes();
    private boolean _whereUsed = false;

    public String CreateQueryString(Object filter, String tableName) {
        // TODO : Skipta þessu string concant út fyrir prepare statement út af sql injection. Sjá:
        // TODO : Nota - jooq eða PreparedStatement í Java jdbc
        String queryString = "SELECT * FROM " + tableName + " ";

        Field[] fields = filter.getClass().getDeclaredFields();

        for (Field f : fields) {
            String condition = _whereUsed ? "WHERE " : "AND ";

            if (isPrimitiveType(f.getClass())) {
                try {
                    Object o = f.get(filter);
                    queryString += condition + " " + o;
                    _whereUsed = true;
                } catch (IllegalAccessException e) { }
            }
            if (isString(f.getClass())) {
                try {
                    Object o = f.get(filter);
                    queryString += "%LIKE% " + o;
                } catch (IllegalAccessException e) { }
            }
        }
        _whereUsed = false;
        return queryString;
    }

    private boolean isString(Class<?> c) {
        return c == String.class;
    }

    private boolean isPrimitiveType(Class<?> c) {
        return _primitiveTypes.contains(c);
    }

    private static Set<Class<?>> getPrimitiveTypes() {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Double.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        return ret;
    }
}

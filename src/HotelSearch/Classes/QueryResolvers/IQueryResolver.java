package HotelSearch.Classes.QueryResolvers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by halldorr on 29/03/16.
 */
public interface IQueryResolver {
    List<Field> equalCondition = new ArrayList();
    List<Field> greaterEqualCondition = new ArrayList();
    List<Field> lesserEqualCondition = new ArrayList();
}

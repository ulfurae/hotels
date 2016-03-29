package HotelSearch.Classes.QueryResolvers;

import HotelSearch.Classes.HotelSearchFilter;
import javax.swing.*;
import java.util.Arrays;

/**
 * Created by halldorr on 29/03/16.
 */
public class HotelQueryResolver implements IQueryResolver {

    public HotelQueryResolver() {
        Class hotel = HotelSearchFilter.class;
        try {
            // Initialize equal List
            equalCondition.addAll(Arrays.asList(hotel.getField("wifi"),
                                                hotel.getField("smoking"),
                                                hotel.getField("breakfast"),
                                                hotel.getField("areaId")));
            // Initialize greaterEqual List
            greaterEqualCondition.addAll(Arrays.asList(hotel.getField("rating"),
                                                       hotel.getField("dateIn")));
            // Initialize lesserEqual List
            lesserEqualCondition.add(hotel.getField("dateOut"));

        } catch (NoSuchFieldException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

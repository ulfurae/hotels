package HotelSearch.Demo;

import HotelSearch.Classes.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Halldor on 26/03/16.
 */
public class MockRepo {

    public static List<Hotel> getHotels(HotelSearchFilter filter) {
        return createFakeHotels();
    }

    private static List<Hotel> createFakeHotels() {
        // Create the first fake hotel
        Hotel hotel1 = new Hotel();
        hotel1.description = "Frábært hótel, lol!";

        hotel1.hotelInfo = new HotelInfo();
        hotel1.hotelInfo.areaId = 2;
        hotel1.hotelInfo.name = "Ruddahótelið";
        hotel1.hotelInfo.breakfast = true;
        hotel1.hotelInfo.rating = 4.7;

        hotel1.area = new Area();
        hotel1.area.name = "Reykjavík";

        // Create the second fake hotel
        Hotel hotel2 = new Hotel();
        hotel2.description = "Ekki svo frábært hótel, æi!";

        hotel2.hotelInfo = new HotelInfo();
        hotel2.hotelInfo.areaId = 1;
        hotel2.hotelInfo.name = "Suave Lounge Hotel";
        hotel2.hotelInfo.rating = 2.5;
        hotel2.hotelInfo.wifi = true;
        hotel2.hotelInfo.smoking = true;

        hotel2.area = new Area();
        hotel2.area.name = "AK city";

        // Return the fake hotels
        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        return hotelList;
    }
}

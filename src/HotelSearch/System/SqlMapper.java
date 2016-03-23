package HotelSearch.System;

import HotelSearch.ListHotel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 * Created by Halldor on 16/03/16.
 */
public class SqlMapper {

    public static <TOut> List<TOut> ToHotel(ResultSet rs) {
        try {
            while (rs.next()) {

            }
        } catch (SQLException e) {

        }

        return (List<TOut>) rs;
    }

    public List<ListHotel>  mapHotels(ResultSet results) {

        List<ListHotel> hotelList = new ArrayList<ListHotel>();

        try {
            while(results.next()) {
                hotelList.add(new ListHotel(results.getString("name"),results.getString("city")));
            }

        } catch (SQLException e) { e.printStackTrace(); }

        return hotelList;
    }
}
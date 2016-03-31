package HotelSearch.System;

import HotelSearch.Classes.Area;
import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelInfo;
import HotelSearch.Demo.ListHotel;

import javax.swing.*;
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

    public List<Hotel> mapHotels(ResultSet results)  {

        System.out.println("yah");

        List<Hotel> hotelList = new ArrayList<Hotel>();
        ArrayList<Hotel> hot = new ArrayList<>();

        int i = 0;
        try {
            while(results.next()) {
                hot.add(i, new Hotel());
                               System.out.print(results.getString("name"));
                hot.get(i).description = results.getString("description").substring(0,100);
                hot.get(i).picture = getImage(1);
                hot.get(i).name = results.getString("name");

                hot.get(i).hotelInfo = new HotelInfo();
                hot.get(i).hotelInfo.areaId = results.getInt("location_id");
                hot.get(i).hotelInfo.breakfast = true;
                hot.get(i).hotelInfo.rating = 4.7;

                hot.get(i).area = new Area();
                hot.get(i).area.name = results.getString("city");
                hotelList.add(hot.get(i));
                i++;
            }

        } catch (SQLException e1) { e1.printStackTrace(); }

        return hotelList;

        /*
        try {
            while(results.next()) {
                hotelList.add(new ListHotel(results.getString("name"),results.getString("city")));
            }

        } catch (SQLException e) { e.printStackTrace(); }  */

    }

    public ImageIcon getImage(int id) {
        return new ImageIcon(this.getClass().getResource("/images/imgDemo" + id + ".jpeg"));
    }

}
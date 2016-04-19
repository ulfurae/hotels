package HotelSearch.System;

import HotelSearch.Classes.*;
import HotelSearch.Demo.ListHotel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class SqlMapper {

    public List<Hotel> mapHotelSearch(ResultSet results)  {


        List<Hotel> hotelList = new ArrayList<>();
        ArrayList<Hotel> hot = new ArrayList<>();

        int i = 0;
        try {
            while(results.next()) {
                hot.add(i, new Hotel());

                hot.get(i).picture = getImage(results.getString("picture"));
                hot.get(i).name = results.getString("name");
                hot.get(i).id = results.getInt("id");
                hot.get(i).description = results.getString("description");

                hot.get(i).hotelInfo = new HotelInfo();
                hot.get(i).hotelInfo.areaId = results.getInt("area_id");
                hot.get(i).hotelInfo.breakfast = results.getBoolean("breakfast");
                hot.get(i).hotelInfo.wifi = results.getBoolean("wifi");
                hot.get(i).hotelInfo.rating = 4.7;

                hot.get(i).area = new Area();
                hot.get(i).area.name = results.getString("area_name");
                hot.get(i).area.city = results.getString("city");
                hotelList.add(hot.get(i));
                i++;
            }

        } catch (SQLException e1) { e1.printStackTrace(); }

        return hotelList;
    }


    public Hotel mapHotel(ResultSet results)  {

        Hotel hot = new Hotel();

        try {
            while(results.next()) {

                hot.picture = getImage(results.getString("picture"));
                hot.name = results.getString("name");
                hot.id = results.getInt("id");
                hot.description = results.getString("description");

                hot.hotelInfo = new HotelInfo();
                hot.hotelInfo.wifi = results.getBoolean("wifi");
                hot.hotelInfo.smoking = results.getBoolean("smoking");
                hot.hotelInfo.breakfast = results.getBoolean("breakfast");
                hot.hotelInfo.rating = 4.7;


                hot.area = new Area();
                hot.area.id = results.getInt("area_id");
                hot.area.name = results.getString("area_name");
                hot.area.city = results.getString("city");
                hot.area.airportName = results.getString("airport");

            }

        } catch (SQLException e1) { e1.printStackTrace(); }

        return hot;
    }

    public ImageIcon getImage(String name) {

        return new ImageIcon(this.getClass().getResource("/pics/" + name + ".jpg"));
    }


    public List<Room> mapHotelRooms(ResultSet results)  {

        List<Room> roomList = new ArrayList<>();
        ArrayList<Room> room = new ArrayList<>();

        int i = 0;
        try {
            while(results.next()) {
                room.add(i, new Room());

                room.get(i).hotelId = results.getInt("hotel_id");
                room.get(i).number = results.getInt("number");

                room.get(i).roomType = new RoomType();

                room.get(i).roomType.id = results.getInt("room_type_id");
                room.get(i).roomType.name = results.getString("name");
                room.get(i).roomType.price = results.getInt("price");
                room.get(i).roomType.description = results.getString("description");
                room.get(i).roomType.max_capacity = results. getInt("max_capacaty");
                roomList.add(room.get(i));

                //System.out.println(room.get(i).roomType.name);
                i++;
            }

        } catch (SQLException e1) { e1.printStackTrace(); }

        return roomList;
    }
}
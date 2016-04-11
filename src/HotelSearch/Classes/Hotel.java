package HotelSearch.Classes;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky Hien on 23.3.2016.
 */
public class Hotel {
    public int id;
    public String name;
    public ImageIcon picture;
    public String description;
    public Review reviews;
    public Area area;
    public Room rooms;
    public HotelInfo hotelInfo;
/**
    public double calculateRating(){

    }

    public List getAvailableRooms(Date din, Date dout){

    }

    public int getAvailableRoomsCount(Date din, Date dout){

    }

    public void bookRoom(Date din, Date dout, int type, int guestID){

    }   */


    public void toHotel(ResultSet results) {
        try {
            while(results.next()) {
                id = results.getInt("id");
                name = results.getString("name");
                description = results.getString("description");

                // ToDo : Finna út úr því hvernig vil viljum geyma/sækja myndir
                //picture = results.getString("picture");


                hotelInfo = new HotelInfo();

                hotelInfo.wifi = results.getBoolean("wifi");
                hotelInfo.smoking = results.getBoolean("smoking");
                hotelInfo.breakfast = results.getBoolean("breakfast");
                hotelInfo.rating = results.getDouble("rating");
                hotelInfo.areaId = results.getInt("areaId");

                area = new Area();

                area.id = results.getInt("id");
                area.name = results.getString("name");
                area.city = results.getString("city");
                area.airportName = results.getString("airport");

                rooms = new Room();

                rooms.toRoom(results);

                reviews = new Review();

                reviews.toReview(results);
            }

        } catch (SQLException e) { e.printStackTrace(); }
    }
}

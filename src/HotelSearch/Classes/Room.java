package HotelSearch.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Room {
    public int hotelId;
    public Hotel hotel;
    public int number;
    public int type;
    public Booking bookings;
    public RoomType roomType;
/**
    public boolean isAvailable(Date din, Date dout){

    }

    public void createBooking(Date din, Date dout, Guest guest){

    }   */

    public void toRoom(ResultSet results) {
        try {
            while(results.next()) {

                hotelId = results.getInt("hotel_id");
                number = results.getInt("number");

                roomType = new RoomType();

                roomType.id = results.getInt("room_type_id");
                roomType.name = results.getString("name");
                roomType.price = results.getInt("price");
                roomType.description = results.getString("description");
                roomType.max_capacity = results. getInt("max_capacity");

                //hotel = new Hotel();

                //hotel.id = results.getInt("id");
                //hotel.name = results.getString("name");

                //bookings = new Booking();

                //bookings.toBooking(results);
            }

        } catch (SQLException e) { e.printStackTrace(); }

    }
}

package HotelSearch.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Ricky Hien on 23.3.2016.
 */
public class Room {
    public int id;
    public Hotel hotel;
    public int roomNumber;
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
                id = results.getInt("id");
                roomNumber = results.getInt("number");


                roomType = new RoomType();

                roomType.id = results.getInt("id");
                roomType.name = results.getString("name");
                roomType.price = results.getInt("price");
                roomType.description = results.getString("description");
                roomType.max_capacity = results. getInt("max_capacity");

                hotel = new Hotel();

                hotel.id = results.getInt("id");
                hotel.hotelInfo.name = results.getString("name");

                bookings = new Booking();

                bookings.toBooking(results);

        }

        } catch (SQLException e) { e.printStackTrace(); }
    }
}

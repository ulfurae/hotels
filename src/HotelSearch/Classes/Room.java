package HotelSearch.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Ricky Hien on 23.3.2016.
 */
public class Room {
    private int id;
    public Hotel hotel;
    public int roomNumber;
    public int price;
    public String type;
    public Booking bookings;
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
                type = results.getString("room_type");
                price = results.getInt("price");

                hotel = new Hotel();

                hotel.hotelInfo.name = results.getString("name");

                bookings = new Booking();

                bookings.toBooking(results);

        }

        } catch (SQLException e) { e.printStackTrace(); }
    }
}

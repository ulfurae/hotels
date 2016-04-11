package HotelSearch.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Ricky Hien on 23.3.2016.
 */
public class Booking {
    public int id;
    public Room room;
    public Guest guest;
    public Date dateIn;
    public Date dateOut;

    public void toBooking(ResultSet results) {
        try {
            while(results.next()) {
                id = results.getInt("id");
                dateIn = results.getDate("date_in");
                dateOut = results.getDate("date_out");

                guest = new Guest();

                guest.id = results.getInt("id");
                guest.name = results.getString("name");
                guest.ssn = results.getInt("ssn");

                room = new Room();

                room.hotelId = results.getInt("Hotel_id");
                room.number = results.getInt("number");
                room.type = results.getInt("room_type_id");

            }

        } catch (SQLException e) { e.printStackTrace(); }
    }
}

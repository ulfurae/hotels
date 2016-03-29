package HotelSearch.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Ricky Hien on 23.3.2016.
 */
public class Booking {
    private int id;
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

                guest.name = results.getString("name");
                guest.ssn = results.getInt("ssn");

                room = new Room();

                room.roomNumber = results.getInt("number");
                room.type = results.getString("room_type");

            }

        } catch (SQLException e) { e.printStackTrace(); }
    }
}

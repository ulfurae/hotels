package HotelSearch.System;

import HotelSearch.Classes.Room;
import java.util.Date;

public class HotelBooker {

    public static boolean bookHotel(String guestName, int guestSsn, Date dateIn, Date dateOut, Room room) {
        int id;
        DbUtils dbUtils = new DbUtils();

        String addGuestSQL = QueryStringBuilder.makeGuestCommand(guestName, guestSsn);
        id = dbUtils.updateDb(addGuestSQL);
        if (id == 0) return false;

        String addBooking = QueryStringBuilder.makeBookingCommand(id, dateIn, dateOut, room);
        return dbUtils.updateDb(addBooking) != 0;
    }

}

package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IBookRoomPanel;
import HotelSearch.Presentation.Interfaces.ISeeHotelPanel;
import HotelSearch.Presentation.Views.BookRoomPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static HotelSearch.Presentation.Views.BookRoomPanel.*;

public class BookRoomPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IBookRoomPanel View;
    private BiConsumer<Boolean,List<Room>> _callback;
    private Hotel _model;
    private List<Room> _rooms;

    public BookRoomPanelPresenter(IBookRoomPanel view, BiConsumer<Boolean,List<Room>> callback, Hotel model) {
        View = view;
        _callback = callback;
        _model = model;

        initializeView();

        View.setBackBtnAction(new backBtnAction());
        View.setBookBtnAction(new bookBtnAction());
    }

    public void update(Hotel model) {
        _model = model;
        initializeView();
    }

    private void initializeView() {

        View.setHotelCity(_model.area.city);
        View.setHotelAreaName(_model.area.name);
        View.setHotelName(_model.name);

        View.setRoomsAvailable(_model.rooms);
    }

    //</editor-fold>

    //<editor-fold desc="Event Handlers">

    class backBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            _callback.accept(true, null);
        }
    }

    class bookBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String nameGuest = View.getGuestName();
            int ssnGuest = View.getGuestSSN();

            System.out.println(nameGuest + "\n" + ssnGuest);

            // info to connect to MySQL database
            final String mysqlUrl = "jdbc:mysql://localhost:3306/hotelDB?allowMultiQueries=true";
            final String mysqlUser = "root";
            final String mysqlPass = "mculli";

            Connection con = null;
            Statement stat1 = null;

            try {
                // connection made to the database
                con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);

                stat1 = con.createStatement();

                String sql = "INSERT INTO Guest (name, ssn) VALUES ('" + nameGuest + "'," + ssnGuest + ");";

                stat1.executeUpdate(sql);

                //sql = "INSERT INTO Booking (hotel_id, date_in, date_out, room_number, guest_id) VALUES();";

                //stat1.executeUpdate(sql);

                View.displayBookingResults();
            }
            catch (SQLException ex) {
                View.displayBookingError();
                Logger lgr = Logger.getLogger(BookRoomPanelPresenter.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            }



        }
    }



    //</editor-fold>
}

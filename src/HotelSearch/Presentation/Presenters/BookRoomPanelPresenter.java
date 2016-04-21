package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IBookRoomPanel;
import HotelSearch.System.HotelBooker;
import HotelSearch.Classes.Pair;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.function.Supplier;

public class BookRoomPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IBookRoomPanel View;
    private BiConsumer<Boolean,List<Room>> _callback;
    private Supplier<Pair<Date,Date>> _dateCallback;
    private Hotel _model;
    private List<Room> _rooms;

    public BookRoomPanelPresenter(IBookRoomPanel view, BiConsumer<Boolean,List<Room>> callback, Supplier<Pair<Date, Date>> getDates, Hotel model) {
        View = view;
        _callback = callback;
        _dateCallback = getDates;
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
        View.clear();
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
            Pair<Date,Date> datePair = _dateCallback.get();

            String guestName = View.getGuestName();
            int ssnGuest = View.getGuestSSN();
            Room room = getRoomOfType(View.getSelectedRoomType());
            Date dateIn = datePair.fst;
            Date dateOut = datePair.snd;

            System.out.println(dateIn);
            System.out.println(dateOut);

            Connection con = null;
            Statement stat1 = null;

            if (room == null || guestName == null || ssnGuest == 0) {

                View.displayBookingError();

            } else {
                boolean success = HotelBooker.bookHotel(guestName, ssnGuest, dateIn, dateOut, room);
                System.out.println(success);
                if (!success)
                    View.displayBookingError();
                else
                    View.displayBookingResults();
            }
        }
    }

    public Room getRoomOfType(String roomTypeName) {
        if(roomTypeName != null) {
            for(int i = 0; i < _model.rooms.size(); i++) {
                if(_model.rooms.get(i).roomType.name.compareTo(roomTypeName) == 0);
                    return _model.rooms.get(0);
            }
        }
        return null;
    }

    //</editor-fold>
}

package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IBookRoomPanel;
import HotelSearch.Presentation.Interfaces.ISeeHotelPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;
import java.util.List;

public class BookRoomPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IBookRoomPanel View;
    private BiConsumer<Boolean,List<Room>> _callback;
    private Hotel _model;
    private List<Room> _rooms;

    public BookRoomPanelPresenter(IBookRoomPanel view, BiConsumer<Boolean,List<Room>> callback, List<Room> rooms) {
        View = view;
        _callback = callback;
        _rooms = rooms;

        initializeView();
    }

    private void initializeView() {
        View.setRoomsAvailable(_rooms);
        View.setBackBtnAction(new backBtnAction());
    }

    //</editor-fold>

    //<editor-fold desc="Event Handlers">

    class backBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            _callback.accept(true, null);
        }
    }

    //</editor-fold>
}

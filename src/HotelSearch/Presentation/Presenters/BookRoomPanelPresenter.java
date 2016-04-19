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

    public BookRoomPanelPresenter(IBookRoomPanel view, BiConsumer<Boolean,List<Room>> callback, Hotel model) {
        View = view;
        _callback = callback;
        _model = model;

        initializeView();

        View.setBackBtnAction(new backBtnAction());
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



    //</editor-fold>
}

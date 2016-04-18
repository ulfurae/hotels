package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.ISeeHotelPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.BiConsumer;

public class SeeHotelPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private ISeeHotelPanel View;
    private BiConsumer<Boolean, List<Room>> _callback;
    private Hotel _model;
    private List<Room> rooms;

    public SeeHotelPanelPresenter(ISeeHotelPanel view, BiConsumer<Boolean,List<Room>> callback, Hotel model) {
        View = view;
        _callback = callback;
        _model = model;

        initializeView();
    }

    private void initializeView() {
        View.setHotelCity(_model.area.city);
        View.setHotelAreaName(_model.area.name);
        View.setHotelName(_model.name);
        View.setHotelPicture(_model.picture);
        View.setHotelDescription(_model.description);
        View.setHotelInfo(_model.hotelInfo);

        View.setBackBtnAction(new backBtnAction());
        View.setBookBtnAction(new bookBtnAction());
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
            _callback.accept(false, rooms);
        }
    }

    //</editor-fold>
}

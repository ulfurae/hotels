package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Presentation.Interfaces.IBookHotelPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

public class BookHotelPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IBookHotelPanel View;
    private BiConsumer<Boolean,Hotel> _callback;
    private Hotel _model;

    public BookHotelPanelPresenter(IBookHotelPanel view, BiConsumer<Boolean,Hotel> callback, Hotel model) {
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

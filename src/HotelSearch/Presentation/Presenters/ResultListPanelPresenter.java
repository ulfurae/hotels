package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IResultListPanel;
import HotelSearch.System.DbUtils;
import HotelSearch.System.QueryStringBuilder;
import HotelSearch.System.SqlMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.Consumer;

public class ResultListPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IResultListPanel View;
    private Hotel _model;
    private Consumer<Hotel> _callback;

    public ResultListPanelPresenter(IResultListPanel view, Consumer<Hotel> callback, Hotel model) {
        View = view;
        _model = model;
        _callback = callback;

        initializeView();
    }

    private void initializeView() {
        View.setBtnAction(new btnAction());
        View.setHotelArea(_model.area.city);
        View.setHotelName(_model.name);
        View.setHotelPicture(_model.picture);
        View.setHotelDescription(_model.description);
        View.setHotelInfo(_model.hotelInfo);
    }

    //</editor-fold>

    //<editor-fold desc="Private">

    private void display(Hotel hotel) {
        _callback.accept(hotel);
    }

    //</editor-fold>

    //<editor-fold desc="Event Handlers">

    class btnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            display(_model);
        }
    }

    //</editor-fold>
}

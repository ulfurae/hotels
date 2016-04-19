package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.ISeeHotelPanel;
import HotelSearch.System.DbUtils;
import HotelSearch.System.QueryStringBuilder;
import HotelSearch.System.SqlMapper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.BiConsumer;

public class SeeHotelPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private ISeeHotelPanel View;
    private BiConsumer<Boolean, Hotel> _callback;
    private Hotel _model;

    public SeeHotelPanelPresenter(ISeeHotelPanel view, BiConsumer<Boolean,Hotel> callback, Hotel model) {
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
        View.setHotelPicture(_model.picture);
        View.setHotelDescription(_model.description);
        View.setHotelInfo(_model.hotelInfo);

    }


    //</editor-fold>

    //<editor-fold desc="Event Handlers">

    class backBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            _callback.accept(true, null);
        }
    }


    private void display(Hotel hotel) {
        _callback.accept(false, hotel);
    }

    private List<Room> getRooms() {

        List<String>  queryList = new QueryStringBuilder().makeHotelRoomsQuery(Integer.toString(_model.id));
        ResultSet results = new DbUtils().SearchDB(queryList);
        return new SqlMapper().mapHotelRooms(results);
    }



    class bookBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            _model.rooms = getRooms();
            display(_model);
        }
    }


    //</editor-fold>
}

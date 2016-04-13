package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IBookHotelPanel;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.Presentation.Views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by ulfurae on 11.4.2016.
 */
public class BookHotelPanelPresenter {


    public IBookHotelPanel View;
    private MainViewPresenter _callback;
    private Hotel _hotelModel;
    private List<Room> _roomsModel;

    public BookHotelPanelPresenter(IBookHotelPanel view, MainViewPresenter callback, Hotel hotelModel, List<Room> roomsModel) {

        View = view;
        _callback = callback;
        _hotelModel = hotelModel;
        _roomsModel = _roomsModel;

        initialize();
    }

    public void initialize() {

        View.setHotelCity(_hotelModel.area.city);
        View.setHotelAreaName(_hotelModel.area.name);
        View.setHotelName(_hotelModel.name);
        View.setHotelPicture(_hotelModel.picture);
        View.setHotelDescription(_hotelModel.description);
        View.setHotelInfo(_hotelModel.hotelInfo);

        View.setBackBtnAction(new backBtnAction());
    }

    class backBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton thisBtn = (JButton) e.getSource();

            _callback.setState(ProgramState.Back);
            _callback.loadView(null);

        }
    }
}

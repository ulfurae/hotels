package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IResultListPanel;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.System.DbUtils;
import HotelSearch.System.QueryStringBuilder;
import HotelSearch.System.SqlMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Halldor on 26/03/16.
 */
public class ResultPanelPresenter {

    public IResultPanel View;
    private MainViewPresenter _callback;
    private List<Hotel> _model;

    public ResultPanelPresenter(IResultPanel view, MainViewPresenter callback, List<Hotel> model) {

        View = view;
        _callback = callback;
        _model = model;

        initialize();
    }

    public void initialize() {

        View.setResultTxt(_model.size() + " hotels found");
        if(_model.size()<2) View.setResultTxt(_model.size() + " hotel found");

        for (Hotel h: _model) {
            IResultListPanel hotelPanel = View.getHotelScroll();

            hotelPanel.setHotelArea(h.area.city);
            hotelPanel.setHotelName(h.name);
            hotelPanel.setHotelPicture(h.picture);
            hotelPanel.setHotelDescription(h.description);
            hotelPanel.setHotelInfo(h.hotelInfo);

            hotelPanel.setModel(h);
            hotelPanel.setBtnName(Integer.toString(h.id));
            hotelPanel.setBtnAction(new btnAction());

            View.addHotelListPanel(hotelPanel);

        }

        View.getView().getParent().validate();
        //View.getView().getParent().repaint();
    }

    private void display(Hotel hotel, List<Room> rooms) {
        _callback.setState(ProgramState.Book);
        _callback.loadBookHotelView(hotel, rooms);
    }

    class btnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton thisBtn = (JButton) e.getSource();
            System.out.println(thisBtn.getName());


            List<String>  queryList = new QueryStringBuilder().makeHotelRoomsQuery(thisBtn.getName());
            ResultSet results = new DbUtils().SearchDB(queryList);
            List<Room> rooms = new SqlMapper().mapHotelRooms(results);

            List<String>  queryList2 = new QueryStringBuilder().makeHotelInfoQuery(thisBtn.getName());
            ResultSet results2 = new DbUtils().SearchDB(queryList2);
            Hotel hotel = new SqlMapper().mapHotel(results2);

            display(hotel,rooms);

        }
    }
}

package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Presentation.Interfaces.ISearchPanel;
import HotelSearch.System.DbUtils;
import HotelSearch.System.QueryStringBuilder;
import HotelSearch.System.SqlMapper;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.List;

public class SearchPanelPresenter{
    //<editor-fold desc="Declaration & Initialization">

    private Consumer _callback;
    private ISearchPanel View;

    public SearchPanelPresenter(ISearchPanel view, Consumer<List<Hotel>> callback) {
        _callback = callback;
        View = view;

        initializeView();
    }

    private void initializeView() {
        View.setSearchBtnAction(new searchBtnAction());
        View.setDateInAction(new dpInAction());
        View.setDateOutAction(new dpOutAction());
    }

    //</editor-fold>

    //<editor-fold desc="Private">

    private void display(List<Hotel> hotels) {
        _callback.accept(hotels);
    }

    private List<Hotel> getHotels() {
        String din = new SimpleDateFormat("yyyy-MM-dd").format(View.getDateIn());
        String dout = new SimpleDateFormat("yyyy-MM-dd").format(View.getDateOut());

        List<String> sendList = new ArrayList<>();
        sendList.add(View.getAreaName());
        sendList.add(din);
        sendList.add(dout);

        List<String>  queryList = new QueryStringBuilder().makeSearchHotelsQuery(sendList);

        ResultSet results = new DbUtils().SearchDB(queryList);

        return new SqlMapper().mapHotelSearch(results);
    }

    //</editor-fold>

    //<editor-fold desc="Event Handlers">

    class searchBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Hotel> hotels = getHotels();
            display(hotels);
        }
    }

    class dpInAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(View.getDateOut().before(View.getDateIn())) {
                View.setDateOut(View.getDateIn());
            }
        }
    }

    class dpOutAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(View.getDateOut().before(View.getDateIn())) {
                JOptionPane.showMessageDialog(null, "Can't select date prior to check-in date");
                View.setDateOut(View.getDateIn());
            }
        }
    }

    //</editor-fold>
}
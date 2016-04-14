package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelSearchFilter;
import HotelSearch.Classes.SqlCustomQuery;
import HotelSearch.Demo.MockRepo;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.Presentation.Interfaces.ISearchPanel;
import HotelSearch.System.DbUtils;
import HotelSearch.System.QueryStringBuilder;
import HotelSearch.System.SqlMapper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.List;

/**
 * Created by Halldor on 22/03/16.
 */
public class SearchPanelPresenter{

    private Consumer _callback;
    public ISearchPanel View;

    public SearchPanelPresenter(ISearchPanel view, Consumer<List<Hotel>> callback) {
        _callback = callback;
        View = view;

        Initialize();
    }

    private void Initialize() {
        View.setSearchBtnAction(new searchBtnAction());
    }

    private void display(List<Hotel> hotels) {
        _callback.accept(hotels);
    }

    class searchBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //getHotels();
            //filter.areaId = View.getAreaId();
            String din = new SimpleDateFormat("yyyy-MM-dd").format(View.getDateIn());
            String dout = new SimpleDateFormat("yyyy-MM-dd").format(View.getDateOut());

            List<String> sendList = new ArrayList<String>();
            sendList.add(View.getAreaName());
            sendList.add(din);
            sendList.add(dout);

            List<String>  queryList = new QueryStringBuilder().makeSearchHotelsQuery(sendList);

            ResultSet results = new DbUtils().SearchDB(queryList);

            List<Hotel> hotels = new SqlMapper().mapHotelSearch(results);

            display(hotels);
        }
    }

    private void getHotels() {
        HotelSearchFilter filter = new HotelSearchFilter();
        // Todo : Finna út úr area combo box
//        filter.areaId = View.getAreaId();

        filter.breakfast = View.getBreakfast();
        filter.smoking = View.getSmoking();
        filter.wifi = View.getWifi();

        filter.dateIn = new Date(View.getDateIn().getTime());
        filter.dateOut = new Date(View.getDateOut().getTime());

        MockRepo mock = new MockRepo();
        List<Hotel> hotels = mock.getHotels(filter);
        display(hotels);
    }
}
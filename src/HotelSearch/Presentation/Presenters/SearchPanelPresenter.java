package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelSearchFilter;
import HotelSearch.Demo.MockRepo;
import HotelSearch.Presentation.Interfaces.ISearchPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.List;

/**
 * Created by Halldor on 22/03/16.
 */
public class SearchPanelPresenter {

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

    private void getHotels() {
        HotelSearchFilter filter = new HotelSearchFilter();

        // Todo : Á að vera hægt að leita eftir nafni? ef svo þarf að setja inn txtfield
//        filter.name = View.getHotelName();
        // Todo : Finna út úr area combo box
//        filter.areaId = View.getAreaId();

        filter.breakfast = View.getBreakfast();
        filter.smoking = View.getSmoking();
        filter.wifi = View.getWifi();

        filter.dateIn = View.getDateIn();
        filter.dateOut = View.getDateOut();

        MockRepo mock = new MockRepo();
        List<Hotel> hotels = mock.getHotels(filter);
        display(hotels);
    }

    class searchBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getHotels();
//            filter.areaId = View.getAreaId();
//            String din = new SimpleDateFormat("yyyy-MM-dd").format(View.getDateIn());
//            String dout = new SimpleDateFormat("yyyy-MM-dd").format(View.getDateOut());
//
//            SqlCustomQuery query = QueryStringBuilder.getSQLQueryString(filter, "Hotel");
//            List<String> sendList = new ArrayList<String>();
//            sendList.add(View.getAreaName());
//            sendList.add(din);
//            sendList.add(dout);
//
//            List<String>  queryList = new QueryStringBuilder().makeHotelQuery(sendList);
//
//            ResultSet results = new DbUtils().SearchDB(query);
        }
    }
}
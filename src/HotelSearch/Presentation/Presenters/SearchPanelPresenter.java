package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.HotelInfo;
import HotelSearch.Classes.HotelSearchFilter;
import HotelSearch.ListHotel;
import HotelSearch.Presentation.Interfaces.ISearchPanel;
import HotelSearch.System.DbUtils;
import HotelSearch.System.QueryStringBuilder;
import HotelSearch.System.SqlMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.function.Function;
import java.util.List;

/**
 * Created by Halldor on 22/03/16.
 */
public class SearchPanelPresenter {

    private Function _callback;
    public ISearchPanel View;
    public JPanel main;
    public JPanel resultPanel;
    public JTextPane resultTxtArea;

    public SearchPanelPresenter(ISearchPanel view) {
        //_callback = callback;
        //View = view;
        View = view;

        Initialize();
    }

    public void Initialize() {

        View.setSearchBtnAction(new searchBtnAction());

        main = View.getPanel();
        resultPanel = View.getResultPanel();
        resultTxtArea = View.getResultTxtArea();
    }

    public void Display(List<HotelInfo> hotels) {
        _callback.apply(hotels);
    }

    public void GetHotels() {
        HotelSearchFilter filter = new HotelSearchFilter();

        filter.name = View.getHotelName();
        filter.DateIn = View.getDateIn();
        filter.DateOut = View.getDateOut();
    }

    // function that populates the resultTxtArea with a ListHotel
    private void showResults(List<ListHotel> hotelList) {

        if (!resultPanel.isVisible()) resultPanel.setVisible(true);
        resultTxtArea.setText("");

        for (ListHotel list : hotelList) {

            resultTxtArea.setText(resultTxtArea.getText() + "\n" + list.name + " - " + list.city + "\n");

        }

    }


    class searchBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            String query = new QueryStringBuilder().makeHotelQuery(View.getAreaName());

            ResultSet results = new DbUtils().SearchDB(query);

            List<ListHotel> hotelList = new SqlMapper().mapHotels(results);

            showResults(hotelList);

        }
    }

}
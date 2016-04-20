package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelSearchFilter;
import HotelSearch.Presentation.Interfaces.ISearchPanel;
import HotelSearch.System.HotelFinder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.List;

public class SearchPanelPresenter{
    //<editor-fold desc="Declaration & Initialization">

    private Consumer<List<Hotel>> _callback;
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
        HotelSearchFilter filter = new HotelSearchFilter();
        filter.dateIn = View.getDateIn();
        filter.dateOut = View.getDateOut();
        filter.areaName = View.getAreaName();
        return new HotelFinder().getHotels(filter);
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
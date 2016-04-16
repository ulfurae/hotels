package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Presentation.Interfaces.IBookHotelPanel;
import HotelSearch.Presentation.Interfaces.IMainView;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.Presentation.Interfaces.ISearchPanel;
import java.util.List;

public class MainViewPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IMainView View;
    private ISearchPanel _searchPanel;
    private ISearchPanel _sideSearchPanel;
    private IResultPanel _resultPanel;
    private IBookHotelPanel _bookHotelPanel;

    public MainViewPresenter(IMainView view, ISearchPanel frontPageP, ISearchPanel sideSearchP,
                             IResultPanel resultP, IBookHotelPanel bookHotelP) {
        View = view;
        _searchPanel = frontPageP;
        _sideSearchPanel = sideSearchP;
        _resultPanel = resultP;
        _bookHotelPanel = bookHotelP;

        initializeView();
    }

    private void initializeView() {
        View.addComponent(_searchPanel);
        new SearchPanelPresenter(_searchPanel, this::searchPanelCallback);
    }

    //</editor-fold>

    //<editor-fold desc="Private">

    private void updateViewVisibility(boolean booking) {
        _bookHotelPanel.getView().setVisible(booking);
        _resultPanel.getView().setVisible(!booking);
        _searchPanel.getView().setVisible(!booking);
    }

    //</editor-fold>

    //<editor-fold desc="View Callbacks">

    private void searchPanelCallback(List<Hotel> hotels) {
        _resultPanel.removeHotels();
        View.addComponent(_resultPanel);
        new ResultPanelPresenter(_resultPanel, this::resultPanelCallback, hotels);
        updateViewVisibility(false);
    }

    private void resultPanelCallback(Hotel hotel) {
        View.addComponent(_bookHotelPanel);
        new BookHotelPanelPresenter(_bookHotelPanel, this::bookingPanelCallback, hotel);
        updateViewVisibility(true);
    }

    private void bookingPanelCallback(boolean backPressed, Hotel hotel) {
        updateViewVisibility(!backPressed);
    }

    //</editor-fold>
}

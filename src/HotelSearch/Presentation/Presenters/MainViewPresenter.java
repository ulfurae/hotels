package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.*;

import java.util.List;

public class MainViewPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IMainView View;
    private ISearchPanel _searchPanel;
    private ISearchPanel _sideSearchPanel;
    private IResultPanel _resultPanel;
    private ISeeHotelPanel _seeHotelPanel;
    private IBookRoomPanel _bookRoomPanel;

    public MainViewPresenter(IMainView view, ISearchPanel frontPageP, ISearchPanel sideSearchP,
                             IResultPanel resultP, ISeeHotelPanel seeHotelP, IBookRoomPanel bookRoomP) {
        View = view;
        _searchPanel = frontPageP;
        _sideSearchPanel = sideSearchP;
        _resultPanel = resultP;
         _seeHotelPanel = seeHotelP;
        _bookRoomPanel = bookRoomP;

        initializeView();
    }

    private void initializeView() {
        View.addComponent(_searchPanel);
        new SearchPanelPresenter(_searchPanel, this::searchPanelCallback);
    }

    //</editor-fold>

    //<editor-fold desc="Private">

    private void updateViewVisibility(boolean booking) {
        _resultPanel.getView().setVisible(!booking);
        _searchPanel.getView().setVisible(!booking);

         _seeHotelPanel.getView().setVisible(booking);
        _bookRoomPanel.getView().setVisible(booking);
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
        View.addComponent( _seeHotelPanel);
        new SeeHotelPanelPresenter( _seeHotelPanel, this::seeHotelPanelCallback, hotel);
        updateViewVisibility(true);
    }



    private void seeHotelPanelCallback(boolean backPressed, List<Room> room) {
        if(backPressed)
            updateViewVisibility(!backPressed);
        else {
            View.addComponent(_bookRoomPanel);
            new BookRoomPanelPresenter( _bookRoomPanel, this::bookRoomPanelCallback, room);
             _seeHotelPanel.getView().setVisible(false);
             _bookRoomPanel.getView().setVisible(true);
        }
    }



    private void bookRoomPanelCallback(boolean backPressed, List<Room> room) { updateViewVisibility(true); }

    //</editor-fold>
}

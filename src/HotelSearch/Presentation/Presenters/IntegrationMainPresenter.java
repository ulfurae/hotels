package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.*;
import HotelSearch.Presentation.Views.BookRoomPanel;
import HotelSearch.Presentation.Views.MainView;
import HotelSearch.Presentation.Views.ResultPanel;
import HotelSearch.Presentation.Views.SeeHotelPanel;

import java.util.List;

public class IntegrationMainPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IMainView View;
    private ISearchPanel _searchPanel;
    private IResultPanel _resultPanel;
    private ISeeHotelPanel _seeHotelPanel;
    private IBookRoomPanel _bookRoomPanel;

    public IntegrationMainPresenter(ISearchPanel searchP) {
        _searchPanel = searchP;
        _resultPanel = new ResultPanel();
        _seeHotelPanel = new SeeHotelPanel();
        _bookRoomPanel = new BookRoomPanel();

        initializeView();
    }

    private void initializeView() {
        new SearchPanelPresenter(_searchPanel, this::searchPanelCallback);
    }

    //</editor-fold>

    //<editor-fold desc="Private">

    private void updateViewVisibility(boolean booking) {
        _resultPanel.getView().setVisible(!booking);
        _searchPanel.getView().setVisible(!booking);

        _seeHotelPanel.getView().setVisible(booking);
    }

    //</editor-fold>

    //<editor-fold desc="View Callbacks">

    private void searchPanelCallback(List<Hotel> hotels) {
        if(View == null) {
            View = new MainView();
            View.addComponent(_searchPanel);
            View.addComponent(_resultPanel);
        }
        _resultPanel.removeHotels();
        new ResultPanelPresenter(_resultPanel, this::resultPanelCallback, hotels);

        updateViewVisibility(false);
    }

    boolean shMade = false;
    SeeHotelPanelPresenter sh;
    private void resultPanelCallback(Hotel hotel) {

        if(!shMade) {
            View.addComponent(_seeHotelPanel);
            sh = new SeeHotelPanelPresenter(_seeHotelPanel, this::seeHotelPanelCallback, hotel);
            shMade = true;

        }
        else sh.update(hotel);

        updateViewVisibility(true);
    }

    boolean brMade = false;
    BookRoomPanelPresenter br;
    private void seeHotelPanelCallback(boolean backPressed, Hotel hotel) {
        if(backPressed)
            updateViewVisibility(!backPressed);
        else {

            if(!brMade) {
                View.addComponent(_bookRoomPanel);
                br = new BookRoomPanelPresenter( _bookRoomPanel, this::bookRoomPanelCallback, hotel);
                brMade = true;
            }
            else br.update(hotel);

            _seeHotelPanel.getView().setVisible(false);
            _bookRoomPanel.getView().setVisible(true);
        }
    }

    private void bookRoomPanelCallback(boolean backPressed, List<Room> room) {
        _seeHotelPanel.getView().setVisible(true);
        _bookRoomPanel.getView().setVisible(false);
    }

    //</editor-fold>
}

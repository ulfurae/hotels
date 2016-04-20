package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.*;
import com.sun.tools.javac.util.Pair;
import java.util.Date;
import java.util.List;

public class MainViewPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IMainView View;
    private ISearchPanel _searchPanel;
    private IResultPanel _resultPanel;
    private ISeeHotelPanel _seeHotelPanel;
    private IBookRoomPanel _bookRoomPanel;

    public MainViewPresenter(IMainView view, ISearchPanel frontPageP, IResultPanel resultP,
                             ISeeHotelPanel seeHotelP, IBookRoomPanel bookRoomP) {
        View = view;
        _searchPanel = frontPageP;
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
    }

    //</editor-fold>

    //<editor-fold desc="View Callbacks">

    private void searchPanelCallback(List<Hotel> hotels) {
        _resultPanel.removeHotels();
        View.addComponent(_resultPanel);
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
                br = new BookRoomPanelPresenter( _bookRoomPanel, this::bookRoomPanelCallback, this::getDates, hotel);
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

    private Pair<Date,Date> getDates() {
        Date in = _searchPanel.getDateIn();
        Date out = _searchPanel.getDateOut();
        return new Pair(in, out);
    }

    //</editor-fold>
}

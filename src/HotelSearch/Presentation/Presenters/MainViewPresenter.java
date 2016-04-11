package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IBookHotelPanel;
import HotelSearch.Presentation.Interfaces.IMainView;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.Presentation.Interfaces.ISearchPanel;
import org.jooq.util.derby.sys.Sys;

import javax.swing.*;
import java.util.List;

/**
 * Created by Halldor on 22/03/16.
 */
public class MainViewPresenter {
    ProgramState state;

    public IMainView View;
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

        initialize();
    }

    private void initialize() {
        // Initialize program State that governs loadView()
        state = ProgramState.Search;

        // load the view
        loadView(null);
    }

    public void setState(ProgramState ns) {
        state = ns;
    }

    public void loadView(List<Hotel> params) {
        _bookHotelPanel.getView().setVisible(false);
        _resultPanel.getView().setVisible(true);
        _searchPanel.getView().setVisible(true);


        switch(state) {
            case Search:
                // Initialize and load view
                View.addComponent(_searchPanel);
                new SearchPanelPresenter(_searchPanel, this);
                // update program state
                state = ProgramState.Result;
                break;
            case Result:
                // remove previous hotels in result panel
                if(params!=null) _resultPanel.removeHotels();
                // Initialize and load view
                View.addComponent(_resultPanel);
                new ResultPanelPresenter(_resultPanel, this, params);
                break;
            case Back:
                state = ProgramState.Result;
                break;
        }
    }

    public void loadBookHotelView(Hotel params1, List<Room> params2) {
        switch(state) {

            case Book:

                _searchPanel.getView().setVisible(false);
                _resultPanel.getView().setVisible(false);
                _bookHotelPanel.getView().setVisible(true);

                // Initialize and load view
                View.addComponent(_bookHotelPanel);
                new BookHotelPanelPresenter(_bookHotelPanel, this, params1, params2);
                break;
        }
    }
}

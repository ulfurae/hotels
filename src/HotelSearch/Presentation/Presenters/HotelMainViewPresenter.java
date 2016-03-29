package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Presentation.Interfaces.IMainView;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.Presentation.Interfaces.ISearchPanel;

import javax.swing.*;
import java.util.List;

/**
 * Created by Halldor on 22/03/16.
 */
public class HotelMainViewPresenter {
    ProgramState state;

    public IMainView View;
    private ISearchPanel _searchPanel;
    private ISearchPanel _sideSearchPanel;
    private IResultPanel _resultPanel;

    public HotelMainViewPresenter(IMainView view, ISearchPanel frontPageP, ISearchPanel sideSearchP, IResultPanel resultP) {
        View = view;
        _searchPanel = frontPageP;
        _sideSearchPanel = sideSearchP;
        _resultPanel = resultP;

        initialize();
    }

    private void initialize() {
        // Initialize program State that governs loadView()
        state = ProgramState.Search;

        // load the view
        loadView(null);
    }

    private void loadView(List<Hotel> params) {
        switch(state) {
            case Search:
                // Initialize and load view
                View.addComponent(_searchPanel);
                SearchPanelPresenter searchPresenter = new SearchPanelPresenter(_searchPanel, this::loadView);
                // update program state
                state = ProgramState.Result;
                break;
            case Result:
                View.addComponent(_resultPanel);
                ResultPanelPresenter resultPresenter = new ResultPanelPresenter(_resultPanel, this::loadView, params);
                state = ProgramState.Book;
                break;
            case Book:
                break;
        }
    }
}

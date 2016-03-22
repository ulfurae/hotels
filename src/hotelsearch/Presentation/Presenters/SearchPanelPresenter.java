package HotelSearch.Presentation.Presenters;

import HotelSearch.Contracts.SearchFilters.HotelSearchFilter;
import HotelSearch.Presentation.Interfaces.ISearchPanel;
import java.util.function.Function;
import HotelSearch.Contracts.DataContracts.*;
import java.util.List;

/**
 * Created by Halldor on 22/03/16.
 */
public class SearchPanelPresenter{

    private Function _callback;
    public ISearchPanel View;

    public SearchPanelPresenter(ISearchPanel view, Function callback) {
        _callback = callback;
        View = view;

        Initialize();
    }

    public void Initialize() {

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
}

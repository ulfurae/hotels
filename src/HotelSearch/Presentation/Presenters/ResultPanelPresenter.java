package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Presentation.Interfaces.IResultListPanel;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import java.util.List;
import java.util.function.Consumer;

public class ResultPanelPresenter {
    //<editor-fold desc="Declaration & Initialization">

    private IResultPanel View;
    private Consumer<Hotel> _callback;
    private List<Hotel> _model;

    public ResultPanelPresenter(IResultPanel view, Consumer<Hotel> callback, List<Hotel> model) {

        View = view;
        _callback = callback;
        _model = model;

        initializeView();
    }

    private void initializeView() {
        View.setResultTxt(_model.size() + " hotels found");

        for (Hotel h: _model) {
            IResultListPanel hotelPanel = View.getNewResultListPanel();
            new ResultListPanelPresenter(hotelPanel, this::display, h);
            View.addHotelListPanel(hotelPanel);
        }

        View.getView().getParent().validate();
    }

    //</editor-fold>

    //<editor-fold desc="Private">

    private void display(Hotel hotel) {
        _callback.accept(hotel);
    }

    //</editor-fold>
}

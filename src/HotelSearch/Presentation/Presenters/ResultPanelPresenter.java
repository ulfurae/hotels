package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Presentation.Interfaces.IHotelListPanel;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Halldor on 26/03/16.
 */
public class ResultPanelPresenter {

    public IResultPanel View;
    private Consumer _callback;
    private List<Hotel> _model;

    public ResultPanelPresenter(IResultPanel view, Consumer<List<Hotel>> callback, List<Hotel> model) {

        View = view;
        _callback = callback;
        _model = model;

        initialize();
    }

    public void initialize() {

        System.out.println(View.getHotelScroll());
        for (Hotel h: _model) {
            IHotelListPanel hotelPanel = View.getHotelScroll();

            hotelPanel.setHotelArea(h.area.name);
            hotelPanel.setHotelName(h.name);
            hotelPanel.setHotelPicture(h.picture);
            hotelPanel.setHotelDescription(h.description);
            hotelPanel.setHotelInfo(h.hotelInfo);

            hotelPanel.setModel(h);

            View.addHotelListPanel(hotelPanel);
        }
        View.getView().getParent().validate();
        View.getView().getParent().repaint();
    }
}

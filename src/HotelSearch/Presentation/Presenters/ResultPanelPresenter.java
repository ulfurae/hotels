package HotelSearch.Presentation.Presenters;

import HotelSearch.Classes.Hotel;
import HotelSearch.Presentation.Interfaces.IResultListPanel;
import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.Presentation.Presenters.MainViewPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Halldor on 26/03/16.
 */
public class ResultPanelPresenter {

    public IResultPanel View;
    private MainViewPresenter _callback;
    private List<Hotel> _model;

    public ResultPanelPresenter(IResultPanel view, MainViewPresenter callback, List<Hotel> model) {

        View = view;
        _callback = callback;
        _model = model;

        initialize();
    }

    public void initialize() {

        View.setResultTxt(_model.size() + " hotels found");
        if(_model.size()<2) View.setResultTxt(_model.size() + " hotel found");

        for (Hotel h: _model) {
            IResultListPanel hotelPanel = View.getHotelScroll();

            hotelPanel.setHotelArea(h.area.city);
            hotelPanel.setHotelName(h.name);
            hotelPanel.setHotelPicture(h.picture);
            hotelPanel.setHotelDescription(h.description);
            hotelPanel.setHotelInfo(h.hotelInfo);

            hotelPanel.setModel(h);
            hotelPanel.setBtnName(Integer.toString(h.id));
            hotelPanel.setBtnAction(new btnAction());

            View.addHotelListPanel(hotelPanel);

        }

        View.getView().getParent().validate();
        //View.getView().getParent().repaint();
    }

    class btnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton thisBtn = (JButton) e.getSource();
            System.out.println(thisBtn.getName());

            _callback.setState(ProgramState.Book);

            _callback.loadView(null);

        }
    }
}

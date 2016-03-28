package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.IHotelListPanel;
import HotelSearch.Presentation.Interfaces.IResultPanel;


import javax.swing.*;
import java.awt.*;

/**
 * Created by helgah on 23/03/16.
 */
public class ResultPanel implements IResultPanel {
    private JPanel hotelList;
    private JLabel lblHotels;
    private JScrollPane hotelScroll;
    private JPanel resultPanel;

    public ResultPanel() {
        hotelScroll.setLayout(new ScrollPaneLayout());
        hotelScroll.setViewportView(hotelList);
        hotelList.setLayout(new GridLayout(0,1));
    }

    public JPanel getView(){
        return resultPanel;
    }

    public IHotelListPanel getHotelScroll() {
        return new HotelListPanel();
    }

    public void addHotelListPanel(IHotelListPanel panel) {
        hotelList.add(panel.getView());
        panel.getView().requestFocus();
    }
}

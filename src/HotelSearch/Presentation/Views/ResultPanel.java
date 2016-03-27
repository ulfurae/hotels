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
    private JPanel hotelListPanel;
    private JPanel resultPanel;

    public JPanel getView(){
        return resultPanel;
    }

    public IHotelListPanel getHotelListPanel() {
        return new HotelListPanel();
    }

    public void addHotelListPanel(IHotelListPanel panel) {
        hotelListPanel.setLayout(new GridLayout(hotelListPanel.getComponentCount()+1,hotelListPanel.getComponentCount()+1));
        hotelListPanel.add(panel.getView());
        hotelListPanel.validate();
        hotelListPanel.repaint();
    }
}

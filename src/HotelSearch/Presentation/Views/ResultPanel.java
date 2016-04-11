package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.IResultListPanel;
import HotelSearch.Presentation.Interfaces.IResultPanel;


import javax.swing.*;
import java.awt.*;

/**
 * Created by helgah on 23/03/16.
 */
public class ResultPanel implements IResultPanel {
    private JPanel hotelList;
    private JLabel lblResults;
    private JScrollPane hotelScroll;
    private JPanel resultPanel;

    public ResultPanel() {

        hotelScroll.setLayout(new ScrollPaneLayout());
        hotelScroll.setViewportView(hotelList);
        hotelList.setLayout(new GridLayout(0,1));

    }

    public void removeHotels() {
        hotelList.removeAll();
    }

    public void removeThis() {
        this.getView().setVisible(false);
    }

    public void setResultTxt(String text) {
        lblResults.setText(text);
    }

    public JPanel getView(){
        return resultPanel;
    }

    public IResultListPanel getHotelScroll() {
        return new ResultListPanel();
    }

    public void addHotelListPanel(IResultListPanel panel) {
        hotelList.add(panel.getView());
        //panel.getView().requestFocus();
    }
}

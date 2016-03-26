package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.IResultPanel;
import HotelSearch.Presentation.Presenters.ResultPanelPresenter;


import javax.swing.*;

/**
 * Created by helgah on 23/03/16.
 */
public class ResultPanel implements IResultPanel {


    private JPanel resultPanel;
    private JButton moreInfoButton;
    private JLabel hotelNameLabel;
    private JLabel hotelAreaLabel;
    private JPanel photoPanel;

    public JPanel displayAvailableHotels (){


        return resultPanel;
    }


}

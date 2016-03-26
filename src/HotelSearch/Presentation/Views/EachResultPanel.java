package HotelSearch.Presentation.Views;

import HotelSearch.Classes.HotelInfo;
import HotelSearch.Presentation.Interfaces.IEachResultPanel;

import javax.swing.*;
import java.util.List;

/**
 * Created by helgah on 23/03/16.
 */
public class EachResultPanel implements IEachResultPanel {

    private JPanel panel1;
    private JTextPane HotelDescription;
    private JList HotelInfo;
    private JButton BookingButton;
    private JPanel HotelPhoto;
    private JScrollPane HotelReview;

    public String displayHotelName(){
        return null;
    }

    public String displayHotelArea(){
        return null;
    }

    public String displayHotelDescription(){
        return null;
    }

    public List displayRooms() {
        return null;
    }

    public List displayReviews() {
        return null;
    }

    public HotelInfo displayHotelInfo() {
        return null;
    }

}

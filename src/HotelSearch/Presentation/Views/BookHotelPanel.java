package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.IBookHotelPanel;

import javax.swing.*;

/**
 * Created by ulfurae on 11.4.2016.
 */
public class BookHotelPanel implements IBookHotelPanel {

    private JPanel picturePanel;
    private JPanel pnlHotelPhoto;
    private JPanel infoPanel;
    private JList jlHotelInfo;
    private JTextPane txtHotelDescription;
    private JLabel lblHotelName;
    private JLabel lblHotelCity;
    private JButton btnBooking;
    private JPanel bookHotelPanel;

    public void BookHotelPanel() {

    }

    public JComponent getView() {
        return bookHotelPanel;
    }
}

package HotelSearch.Presentation.Views;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelInfo;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IBookRoomPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

public class BookRoomPanel implements IBookRoomPanel {


    private JPanel infoPanel;
    private JTextPane txtHotelDescription;
    private JLabel lblHotelName;
    private JLabel lblHotelCity;
    private JButton btnBack;
    private JLabel lblAreaName;
    private JPanel bookRoomPanel;

    private Hotel _model;

    public BookRoomPanel() {

    }

    public JComponent getView() {
        return bookRoomPanel;
    }

    public void setRoomsAvailable(List<Room> room) {
        for(Room r: room){
            txtHotelDescription.setText(String.valueOf(r.roomType));
        }
    }


    public void setBackBtnAction(ActionListener evt) {
        btnBack.addActionListener(evt);
    }
    public void setBookBtnAction(ActionListener evt) {
        btnBack.addActionListener(evt);
    }
}

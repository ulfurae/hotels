package HotelSearch.Presentation.Views;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.Room;
import HotelSearch.Presentation.Interfaces.IBookRoomPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import java.lang.String;

public class BookRoomPanel implements IBookRoomPanel {


    private JPanel infoPanel;
    private JLabel lblHotelName;
    private JLabel lblHotelCity;
    private JButton btnBack;
    private JLabel lblAreaName;
    private JPanel bookRoomPanel;
    private JRadioButton roomType3;
    private JRadioButton roomType1;
    private JRadioButton roomType2;
    private JRadioButton roomType4;
    private JLabel roomDesc;
    private JLabel infoRequest;
    private JTextArea nameInput;
    private JTextArea ssnInput;
    private JLabel guestName;
    private JLabel ssN;
    private JButton btnBook;
    private JLabel bookingResult;

    private Hotel _model;

    public BookRoomPanel() {

    }

    public JComponent getView() {
        return bookRoomPanel;
    }

    public void setHotelName(String name) { lblHotelName.setText(name); }

    public void setHotelAreaName(String area) {
        lblAreaName.setText(area);
    }

    public void setHotelCity(String area) { lblHotelCity.setText("- " + area);  }

    public String getGuestName() { return nameInput.getText(); }

    public int getGuestSSN() {return Integer.parseInt(ssnInput.getText()); }

    public void displayBookingResults() {

        String name = getGuestName();

        bookingResult.setText("Booking Successful! Enjoy your stay " + name + ".");
    }

    public void displayBookingError() {
        bookingResult.setText("There was a problem with your booking.");};

    public void setRoomsAvailable(List<Room> room) {

            roomDesc.setText("Please Choose a Room Type:" + "\n");
            roomType1.setText("");
            roomType2.setText("");
            roomType3.setText("");
            roomType4.setText("");

            ButtonGroup bg = new ButtonGroup();

            Room r1 = room.get(0);
            Room r2 = room.get(1);
            Room r3 = room.get(2);
            Room r4 = room.get(3);

            roomType1.setText(r1.roomType.name + "\n");
            roomType2.setText(r2.roomType.name + "\n");
            roomType3.setText(r3.roomType.name + "\n");
            roomType4.setText(r4.roomType.name + "\n");

            bg.add(roomType1);
            bg.add(roomType2);
            bg.add(roomType3);
            bg.add(roomType4);

            // Guest info form
            infoRequest.setText("Please fill out the following form: " + "\n\n");
            guestName.setText("Name: ");
            ssN.setText("Social Security Number: ");
            btnBook.setText("Book Now!");
        }


    public void setBackBtnAction(ActionListener evt) {
        btnBack.addActionListener(evt);
    }
    public void setBookBtnAction(ActionListener evt) {
        btnBook.addActionListener(evt);
    }
}

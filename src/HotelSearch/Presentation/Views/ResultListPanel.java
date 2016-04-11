package HotelSearch.Presentation.Views;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelInfo;
import HotelSearch.Presentation.Interfaces.IResultListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * Created by helgah on 23/03/16.
 */
public class ResultListPanel implements IResultListPanel {

    private JPanel eachHotelPanel;
    private JButton btnBooking;
    private JPanel pnlHotelPhoto;
    private JList jlHotelInfo;
    private JTextPane txtHotelDescription;
    private JPanel picturePanel;
    private JPanel infoPanel;
    private JLabel lblHotelName;
    private JLabel lblHotelCity;

    public ResultListPanel() {

        pnlHotelPhoto.setLayout(new GridLayout(0,1));
        btnBooking.setText("See hotel");
        btnBooking.setBackground(new Color(95,95,95));
    }

    private Hotel _model;

    public JPanel getView() {
        return eachHotelPanel;
    }

    public Hotel getModel() {
        return _model;
    }

    public void setModel(Hotel hotel) {
        _model = hotel;
    }

    public void setHotelName(String name) {
        lblHotelName.setText(name);
    }

    public void setHotelArea(String area) {
        lblHotelCity.setText(area);
    }

    public void setHotelPicture(ImageIcon img) {

        int scale = 3; // 2 times smaller
        int width = img.getIconWidth();
        int newWidth = width / scale;

        JLabel label = new JLabel("", new ImageIcon(img.getImage().getScaledInstance(newWidth, -1,
                java.awt.Image.SCALE_SMOOTH)), JLabel.CENTER);

        pnlHotelPhoto.add(label);
    }

    public void setHotelDescription(String description) {
        txtHotelDescription.setText(description);
    }

    public void setHotelInfo(HotelInfo hotelInfo) {
        DefaultListModel model = new DefaultListModel();

        Field[] fields = hotelInfo.getClass().getFields();

        for (Field f: fields) {
            try {
                model.addElement(f.getName().toString() + ": " + f.get(hotelInfo).toString());

            } catch(Exception e) { }
        }
        jlHotelInfo.setModel(model);
    }

    public void setBtnAction(ActionListener evt) { btnBooking.addActionListener(evt);   }
    public void setBtnName(String id) { btnBooking.setName(id);  }
}

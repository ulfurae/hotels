package HotelSearch.Presentation.Views;

import HotelSearch.Classes.HotelInfo;
import HotelSearch.Presentation.Interfaces.IBookHotelPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

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
    private JButton btnBack;
    private JPanel bookHotelPanel;
    private JLabel lblAreaName;

    public BookHotelPanel() {
        pnlHotelPhoto.setLayout(new GridLayout(0,1));
        btnBack.setText("<- Back");
        btnBack.setBackground(new Color(95,95,95));
    }

    public JComponent getView() {
        return bookHotelPanel;
    }

    public void setHotelName(String name) { lblHotelName.setText(name); }
    public void setHotelAreaName(String area) {
        lblAreaName.setText(area);
    }
    public void setHotelCity(String area) { lblHotelCity.setText("- " + area);  }

    public void setHotelPicture(ImageIcon img) {

        pnlHotelPhoto.removeAll();
        int scale = 2; // 2 times smaller
        int width = img.getIconWidth();
        int newWidth = width / scale + 100;

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

    public void setBackBtnAction(ActionListener evt) {
        btnBack.addActionListener(evt);
    };
}

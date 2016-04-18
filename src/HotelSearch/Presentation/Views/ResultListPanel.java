package HotelSearch.Presentation.Views;

import HotelSearch.Classes.HotelInfo;
import HotelSearch.Presentation.Interfaces.IResultListPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class ResultListPanel implements IResultListPanel {

    private JPanel eachHotelPanel;
    private JButton btnBooking;
    private JPanel pnlHotelPhoto;
    private JList<String> jlHotelInfo;
    private JTextPane txtHotelDescription;
    private JPanel picturePanel;
    private JPanel infoPanel;
    private JLabel lblHotelName;
    private JLabel lblHotelCity;

    public ResultListPanel() {
        pnlHotelPhoto.setLayout(new GridLayout(0,1));
    }

    public JPanel getView() {
        return eachHotelPanel;
    }

    public void setHotelName(String name) {
        lblHotelName.setText(name);
    }

    public void setHotelArea(String area) {
        lblHotelCity.setText(area);
    }

    public void setHotelPicture(ImageIcon img) {

        int width = img.getIconWidth();
        int newWidth = width / 3;

        JLabel label = new JLabel("", new ImageIcon(img.getImage().getScaledInstance(newWidth, -1,
                java.awt.Image.SCALE_SMOOTH)), JLabel.CENTER);

        pnlHotelPhoto.add(label);
    }

    public void setHotelDescription(String description) {
        txtHotelDescription.setText(description.substring(0, 130) + "...");
    }

    public void setHotelInfo(HotelInfo hotelInfo) {
        DefaultListModel<String> model = new DefaultListModel<>();

        Field[] fields = hotelInfo.getClass().getFields();

        for (Field f: fields) {
            try {
                model.addElement(f.getName() + ": " + f.get(hotelInfo).toString());

            } catch(Exception e) { e.printStackTrace(); }
        }
        jlHotelInfo.setModel(model);
    }

    public void setBtnAction(ActionListener evt) { btnBooking.addActionListener(evt); }
}

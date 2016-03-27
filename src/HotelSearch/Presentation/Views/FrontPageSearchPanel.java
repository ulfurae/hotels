package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.ISearchPanel;
import com.michaelbaranov.microba.calendar.DatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Date;

/**
 * Created by Halldor on 22/03/16.
 */
public class FrontPageSearchPanel extends JPanel implements ISearchPanel{
    private JPanel searchPanel;
    private JPanel filterPanel;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JTextPane resultTxtArea;
    private JTextField txtName;
    private JCheckBox chkWifi;
    private JCheckBox chkSmoking;
    private JCheckBox chkBreakfast;
    private DatePicker dpDateOut;
    private DatePicker dpDateIn;
    private JComboBox areaComboBox;
    private JButton searchBtn;

    public FrontPageSearchPanel() {

        dpDateIn.addActionListener(new dpInAction());
        dpDateOut.addActionListener(new dpOutAction());
    }

    class dpInAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(dpDateOut.getDate().before(dpDateIn.getDate())) {
                try {
                    //Date increment = DateUtils.addDays(today, 1);
                    dpDateOut.setDate(dpDateIn.getDate());
                } catch (PropertyVetoException e1) { e1.printStackTrace(); }
            }
        }
    }

    class dpOutAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(dpDateOut.getDate().before(dpDateIn.getDate())) {

                JOptionPane.showMessageDialog(null, "Can't select date prior to check-in date");
                try {
                    dpDateOut.setDate(dpDateIn.getDate());
                } catch (PropertyVetoException e1) { e1.printStackTrace(); }
            }
        }
    }

    public JPanel getView() {
        return searchPanel;
    }

    public String getHotelName() { return txtName.getText(); }

    public int getAreaId() {
         return (Integer) areaComboBox.getSelectedItem();
    }

    public String getAreaName() {
        return areaComboBox.getSelectedItem().toString();
    }

    public boolean getWifi() {
        return chkWifi.isSelected();
    }

    public boolean getSmoking(){
        return chkSmoking.isSelected();
    }

    public boolean getBreakfast() {
        return chkBreakfast.isSelected();
    }

    public Date getDateIn() {
        return dpDateIn.getDate();
    }

    public Date getDateOut() {
        return dpDateOut.getDate();
    }

    public void setSearchBtnAction(ActionListener evt) {
        searchBtn.addActionListener(evt);
    };
}

package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.ISearchPanel;
import com.michaelbaranov.microba.calendar.DatePicker;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Halldor on 22/03/16.
 */
public class HotelSearchPanel implements ISearchPanel {


    private JPanel searchPanel;
    private JPanel filterPanel;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JTextField txtName;
    private JCheckBox chkWifi;
    private JCheckBox chkSmoking;
    private JCheckBox chkBreakfast;
    private DatePicker dpDateIn;
    private DatePicker dpDateOut;
    private JComboBox areaComboBox;
    private JButton searchBtn;
    private JTextPane resultTxtArea;

    public HotelSearchPanel() {


    }

    public JPanel getPanel() {
        return searchPanel;
    }

    public String getHotelName() {
        return txtName.getText();
    }

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

    public JPanel getFilterPanel() {
        return filterPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getResultPanel() {
        return resultPanel;
    }

    public JTextPane getResultTxtArea() {
        return resultTxtArea;
    }

    public void setSearchBtnAction(ActionListener evt) {
        searchBtn.addActionListener(evt);
    };


}

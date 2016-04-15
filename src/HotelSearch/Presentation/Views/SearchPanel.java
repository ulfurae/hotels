package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.ISearchPanel;
import com.michaelbaranov.microba.calendar.DatePicker;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Date;

public class SearchPanel extends JPanel implements ISearchPanel{
    private JPanel searchPanel;
    private JPanel filterPanel;
    private JPanel mainPanel;
    private JTextField txtName;
    private JCheckBox chkWifi;
    private JCheckBox chkSmoking;
    private JCheckBox chkBreakfast;
    private DatePicker dpDateOut;
    private DatePicker dpDateIn;
    private JComboBox areaComboBox;
    private JButton searchBtn;

    public JPanel getView() {
        return searchPanel;
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

    public Date getDateIn() { return dpDateIn.getDate(); }

    public Date getDateOut() {
        return dpDateOut.getDate();
    }

    public void setDateOut(Date dateOut) {
        try {
            dpDateOut.setDate(dateOut);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public void setDateInAction(ActionListener evt) { dpDateIn.addActionListener(evt); }

    public void setDateOutAction(ActionListener evt) { dpDateOut.addActionListener(evt); }

    public void setSearchBtnAction(ActionListener evt) { searchBtn.addActionListener(evt); }
}

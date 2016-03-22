package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.ISearchPanel;
import com.michaelbaranov.microba.calendar.DatePicker;

import javax.swing.*;
import java.util.Date;

/**
 * Created by Halldor on 22/03/16.
 */
public class FrontPageSearchPanel implements ISearchPanel{
    private JTabbedPane tabbedPane1;
    private JPanel searchPanel;
    private JTextField txtName;
    private JCheckBox chkWifi;
    private JCheckBox chkSmoking;
    private JCheckBox chkBreakfast;
    private JComboBox cboArea;
    private DatePicker dpDateIn;
    private DatePicker dpDateOut;

    public String getHotelName() {
        return txtName.getText();
    }

    public int getAreaId() {
         return (Integer)cboArea.getSelectedItem();
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
}

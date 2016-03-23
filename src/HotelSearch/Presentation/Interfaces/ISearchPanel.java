package HotelSearch.Presentation.Interfaces;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Halldor on 22/03/16.
 */
public interface ISearchPanel {

    String getHotelName();

    int getAreaId();

    String getAreaName();

    boolean getWifi();

    boolean getSmoking();

    boolean getBreakfast();

    Date getDateIn();

    Date getDateOut();

    JPanel getPanel();

    JPanel getFilterPanel();
    JPanel getMainPanel();
    JPanel getResultPanel();

    JTextPane getResultTxtArea();

    void setSearchBtnAction(ActionListener evt);
}

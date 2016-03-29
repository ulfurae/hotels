package HotelSearch.Presentation.Interfaces;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Halldor on 22/03/16.
 */
public interface ISearchPanel extends IView {

    String getHotelName();

    int getAreaId();

    String getAreaName();

    boolean getWifi();

    boolean getSmoking();

    boolean getBreakfast();

    Date getDateIn();

    Date getDateOut();

    void setSearchBtnAction(ActionListener evt);
}

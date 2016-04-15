package HotelSearch.Presentation.Interfaces;

import java.awt.event.ActionListener;
import java.util.Date;

public interface ISearchPanel extends IView {
    String getAreaName();

    boolean getWifi();

    boolean getSmoking();

    boolean getBreakfast();

    Date getDateIn();

    Date getDateOut();

    void setDateOut(Date dateOut);

    void setDateInAction(ActionListener evt);

    void setDateOutAction(ActionListener evt);

    void setSearchBtnAction(ActionListener evt);
}

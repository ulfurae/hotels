package HotelSearch.Presentation.Interfaces;

import java.util.Date;

/**
 * Created by Halldor on 22/03/16.
 */
public interface ISearchPanel {
    String getHotelName();

    int getAreaId();

    boolean getWifi();

    boolean getSmoking();

    boolean getBreakfast();

    Date getDateIn();

    Date getDateOut();
}

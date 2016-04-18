package HotelSearch.Presentation.Interfaces;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelInfo;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by ulfurae on 11.4.2016.
 */
public interface ISeeHotelPanel extends IView {


    void setHotelName(String name);

    void setHotelAreaName(String area);

    void setHotelCity(String area);

    void setHotelPicture(ImageIcon icon);

    void setHotelDescription(String description);

    void setHotelInfo(HotelInfo hotelInfo);

    void setBackBtnAction(ActionListener evt);

    void setBookBtnAction(ActionListener evt);

}

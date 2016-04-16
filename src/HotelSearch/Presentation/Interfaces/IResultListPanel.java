package HotelSearch.Presentation.Interfaces;

import HotelSearch.Classes.HotelInfo;
import javax.swing.*;
import java.awt.event.ActionListener;


public interface IResultListPanel extends IView {
    void setHotelName(String name);

    void setHotelArea(String area);

    void setHotelPicture(ImageIcon icon);

    void setHotelDescription(String description);

    void setHotelInfo(HotelInfo hotelInfo);

    void setBtnAction(ActionListener evt);
}

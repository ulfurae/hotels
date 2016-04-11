package HotelSearch.Presentation.Interfaces;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelInfo;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


/**
 * Created by helgah on 23/03/16.
 */
public interface IResultListPanel extends IView {

    Hotel getModel();

    void setModel(Hotel hotel);

    void setHotelName(String name);

    void setHotelArea(String area);

    void setHotelPicture(ImageIcon icon);

    void setHotelDescription(String description);

    void setHotelInfo(HotelInfo hotelInfo);

    void setBtnAction(ActionListener evt);

    void setBtnName(String id);
}

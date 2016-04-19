package HotelSearch.Presentation.Interfaces;

import HotelSearch.Classes.HotelInfo;
import HotelSearch.Classes.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by ulfurae on 11.4.2016.
 */
public interface IBookRoomPanel extends IView {

    void setHotelName(String name);

    void setHotelAreaName(String area);

    void setHotelCity(String area);

    void setRoomsAvailable(List<Room> rooms);

    void setBackBtnAction(ActionListener evt);

    void setBookBtnAction(ActionListener evt);

    //void setBtnName(String id);

}

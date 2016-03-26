package HotelSearch.Presentation.Interfaces;

import HotelSearch.Classes.HotelInfo;

import java.util.*;
import java.util.List;


/**
 * Created by helgah on 23/03/16.
 */
public interface IEachResultPanel {

    String displayHotelName();

    String displayHotelArea();

    String displayHotelDescription();

    List displayReviews();

    List displayRooms();

    HotelInfo displayHotelInfo();

}

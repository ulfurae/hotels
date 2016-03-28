package HotelSearch.Presentation.Interfaces;

import javax.swing.*;

/**
 * Created by helgah on 23/03/16.
 */
public interface IResultPanel extends IView {
    IHotelListPanel getHotelScroll();

    void addHotelListPanel(IHotelListPanel panel);
}

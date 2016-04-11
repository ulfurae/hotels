package HotelSearch.Presentation.Interfaces;

/**
 * Created by helgah on 23/03/16.
 */
public interface IResultPanel extends IView {
    IResultListPanel getHotelScroll();

    void addHotelListPanel(IResultListPanel panel);

    void removeHotels();

    void setResultTxt(String text);
}

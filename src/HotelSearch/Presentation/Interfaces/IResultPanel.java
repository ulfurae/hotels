package HotelSearch.Presentation.Interfaces;

public interface IResultPanel extends IView {
    IResultListPanel getNewResultListPanel();

    void addHotelListPanel(IResultListPanel panel);

    void removeHotels();

    void setResultTxt(String text);
}

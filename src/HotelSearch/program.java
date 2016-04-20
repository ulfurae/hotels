package HotelSearch;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import HotelSearch.Presentation.Presenters.MainViewPresenter;
import HotelSearch.Presentation.Views.*;


/**
 * Created by ulfurae on 22.3.2016.
 */
public class program {
    //// START HOTEL SEARCH APP \\\\
    public static void main(String[] args) {
        setLook();

        MainViewPresenter presenter = new MainViewPresenter(new MainView(),
                                                            new SearchPanel(),
                                                            new ResultPanel(),
                                                            new SeeHotelPanel(),
                                                            new BookRoomPanel());
    }

    static void setLook() {
        try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); }
        catch (UnsupportedLookAndFeelException e) { e.printStackTrace();}
    }
}

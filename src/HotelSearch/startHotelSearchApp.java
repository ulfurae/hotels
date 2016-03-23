package HotelSearch;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import HotelSearch.Presentation.Views.HotelSearchPanel;
import HotelSearch.Presentation.Views.MainAppFrame;
import HotelSearch.Presentation.Presenters.SearchPanelPresenter;

/**
 * Created by ulfurae on 22.3.2016.
 */
public class startHotelSearchApp {


    //// START HOTEL SEARCH APP \\\\
    public static void main(String[] args) {

        setLook();

        MainAppFrame frame = new MainAppFrame();

        HotelSearchPanel searchPanel = new HotelSearchPanel();
        SearchPanelPresenter presenter = new SearchPanelPresenter(searchPanel);

        frame.getFrame().add(presenter.main);
    }

    static void setLook() {

        try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); }
        catch (UnsupportedLookAndFeelException e) { e.printStackTrace();}
    }
}

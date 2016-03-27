package HotelSearch;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import HotelSearch.Presentation.Presenters.HotelMainViewPresenter;
import HotelSearch.Presentation.Views.FrontPageSearchPanel;
import HotelSearch.Presentation.Views.HotelMainView;
import HotelSearch.Presentation.Presenters.SearchPanelPresenter;
import HotelSearch.Presentation.Views.ResultPanel;

/**
 * Created by ulfurae on 22.3.2016.
 */
public class program {
    //// START HOTEL SEARCH APP \\\\
    public static void main(String[] args) {
        setLook();

        HotelMainViewPresenter presenter = new HotelMainViewPresenter(new HotelMainView(),
                                                                      new FrontPageSearchPanel(),
                                                                      new FrontPageSearchPanel(),
                                                                      new ResultPanel());
    }

    static void setLook() {
        try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); }
        catch (UnsupportedLookAndFeelException e) { e.printStackTrace();}
    }
}

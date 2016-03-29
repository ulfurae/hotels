package HotelSearch;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import HotelSearch.Classes.HotelSearchFilter;
import HotelSearch.Classes.QueryResolvers.HotelQueryResolver;
import HotelSearch.Classes.SqlCustomQuery;
import HotelSearch.Presentation.Presenters.HotelMainViewPresenter;
import HotelSearch.Presentation.Views.FrontPageSearchPanel;
import HotelSearch.Presentation.Views.HotelMainView;
import HotelSearch.Presentation.Views.ResultPanel;
import HotelSearch.System.QueryStringBuilder;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Created by ulfurae on 22.3.2016.
 */
public class program {
    //// START HOTEL SEARCH APP \\\\
    public static void main(String[] args) {
        setLook();

        HotelSearchFilter hotel = new HotelSearchFilter();

        hotel.wifi = true;
        hotel.rating = 2.0;

        Calendar cal = new GregorianCalendar();
        cal.set(1990, 10, 13, 0, 0);
        hotel.dateIn = new Date(cal.getTimeInMillis());
        cal.set(2000, 10, 13, 0, 0);
        hotel.dateOut = new Date(cal.getTimeInMillis());

        SqlCustomQuery q = QueryStringBuilder.getSQLQueryString(hotel, "Hotel", new HotelQueryResolver());

        System.out.println(q.sqlStatement);
        System.out.println(q.values);

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

package HotelSearch.Presentation.Views;

import HotelSearch.HotelSearch;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

/**
 * Created by Halldor on 22/03/16.
 */
public class MainAppFrame extends JFrame {

    public JFrame mainFrame = new JFrame("Search for hotels in Iceland");

    // Creates main frame for the hotel search app
    public MainAppFrame() {

        mainFrame.setSize(600,700);
        mainFrame.setMinimumSize(new Dimension(500,400));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setVisible(true);
    }

    public JFrame getFrame() {

        return mainFrame;
    }
}

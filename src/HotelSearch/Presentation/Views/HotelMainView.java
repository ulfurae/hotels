package HotelSearch.Presentation.Views;

import HotelSearch.Presentation.Interfaces.IMainView;
import HotelSearch.Presentation.Interfaces.IView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Halldor on 22/03/16.
 */
public class HotelMainView extends JFrame implements IMainView {

    public JFrame mainFrame = new JFrame("Search for hotels in Iceland");
    private JPanel mp;

    // Creates main frame for the hotel search app
    public HotelMainView() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(600, 650));
        mainFrame.setResizable(true);
        mainFrame.add(mp);
        mainFrame.setVisible(true);
    }

    public void addComponent(IView view) {
        mp.add(view.getView());
        //mainFrame.pack();
        //mainFrame.setVisible(true);
    }
}

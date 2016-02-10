package hotelsearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ListHotel {

    public String name;
    public String city;
    public ListHotel(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class Main {

    private static String mysqlUrl = "jdbc:mysql://localhost:3306/hotelDB";
    private static String mysqlUser = "root";
    private static String mysqlPass = "mculli";

    private static JTextField entry = new JTextField();
    private static JButton button = new JButton();
    private static JTextArea area = new JTextArea("blabla", 6, 8);

    public static void main(String[] args) {

        JFrame myFrame = new JFrame("Search hotels");
        myFrame.setSize(400,500);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        //myFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();

        Box box = Box.createVerticalBox();

        entry.setSize(200,30);
        entry.setVisible(true);
        button.setText("Search");
        area.setSize(200,30);
        area.setText("Search");

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getPPtuff();
            }

            public void mousePressed(MouseEvent e) {         }

            public void mouseReleased(MouseEvent e) {        }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }

        });
        box.add(entry);
        box.add(button);
        box.add(area);

        panel.add(box);
        myFrame.add(panel);


    }

    public static void getPPtuff() {

        List<ListHotel> hotelList = new ArrayList<ListHotel>();
        area.setText("");
        Connection mysqlCon = null;
        Statement statement = null;
        ResultSet result = null;

        String queryStr = "Select Hotel.name, Hotel.type, Hotel.city, Location.airport\n" +
                "From Hotel, Location\n" +
                "Where Hotel.location_id = Location.id";

        try {

            mysqlCon = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);
            statement = mysqlCon.createStatement();
            result = statement.executeQuery(queryStr);

            while(result.next()) {
                hotelList.add(new ListHotel(result.getString("name"),result.getString("city")));
            }

            for (ListHotel e : hotelList) {

                if(e.city.equals(entry.getText())) {
                    area.setText(area.getText() + "\n" + e.name + " - " + e.city);

                }
            }


        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {   if (result != null) result.close();
                    if (statement != null) statement.close();
                    if (mysqlCon != null) mysqlCon.close();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Main.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }  // end of try, catch, finally


    }
}

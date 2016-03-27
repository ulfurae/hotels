package HotelSearch;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelSearch {

    //// LOCAL VARIABLES \\\\

    // info to connect to MYSQL database
    private final String mysqlUrl = "jdbc:mysql://localhost:3306/hotelDB";
    private final String mysqlUser = "root";
    private final String mysqlPass = "mculli";


    public JPanel ss;
    private JComboBox areaComboBox;
    private JButton searchBtn;
    private JPanel resultPanel;
    private JPanel searchPanel;
    private JTextPane resultTxtArea;

    //// MAIN FUNCTION \\\\
    public static void main(String[] args) {

        try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); }
        catch (UnsupportedLookAndFeelException e) { e.printStackTrace();}

        HotelSearch hotelSearch = new HotelSearch();

        hotelSearch.makeMainFrame();
    }

    // Function that creates main frame for the hotels search
    private void makeMainFrame() {


        JFrame mainFrame = new JFrame("Search For Hotels");
        JPanel mainPanel = new JPanel();
        Box vertBox = Box.createVerticalBox();

        mainFrame.setSize(400,600);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.add(ss);

        searchBtn.addActionListener(new searchBtnAction());

        mainFrame.setVisible(true);

        resultPanel.setVisible(false);
    }

    // Function that creates main frame for the hotels search
    public void make() {

        searchBtn.addActionListener(new searchBtnAction());


        resultPanel.setVisible(false);
    }

    // Function that creates main frame for the hotels search
    public JPanel getPanel() {


        return ss;
    }

    // function that searches the database with a input string
    private void searchDatabase(String inputStr) {

        Connection con = null;
        PreparedStatement stat = null;
        ResultSet results = null;

        // List with hotels from search result
        List<ListHotel> hotelList = new ArrayList<ListHotel>();

        // query that is used to get results from the database
        String mainQuery = "Select Hotel.name, Hotel.type, Hotel.city, Location.airport \n" +
                "From Hotel, Location \n" +
                "Where Hotel.location_id = Location.id \n";

        if(inputStr!="All areas")
            mainQuery = mainQuery + "and Location.name = ?";

        try {
            // connection made to the database
            con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);

            // query is executed through a prepared statement and the ? is set as the value of inputStr
            stat = con.prepareStatement(mainQuery);

            if(inputStr!="All areas")
                stat.setString(1, inputStr);

            // the query is executed and the result is put into results
            results = stat.executeQuery();

            // loops through results and adds to the hotelList
            while(results.next()) {
                hotelList.add(new ListHotel(results.getString("name"),results.getString("city")));
            }

          // error-handling for the MYSQL database connection
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(HotelSearch.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {   if (results != null) results.close();
                    if (stat != null) stat.close();
                    if (con != null) con.close();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(HotelSearch.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }  // end of try, catch and finally

        // run the function showResults with the new hotelList
        showResults(hotelList);
    }

    // function that populates the resultTxtArea with a ListHotel
    private void showResults(List<ListHotel> hotelList)  {

        if(!resultPanel.isVisible()) resultPanel.setVisible(true);
        resultTxtArea.setText("");

        for (ListHotel list : hotelList) {

            resultTxtArea.setText(resultTxtArea.getText() + "\n" + list.name + " - " + list.city + "\n");

        }

    }

    class searchBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // calls searchDatabase with the text from searchTxtInput
            searchDatabase(areaComboBox.getSelectedItem().toString());

        }
    }
}
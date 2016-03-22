package hotelsearch;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by helgah on 16/03/16.
 */
public class DbUtils {

    public static ResultSet SearchDB(String QueryString) {

        ResultSet resultSet;

        // info to connect to MySQL database
        final String mysqlUrl = "jdbc:mysql://localhost:3306/hotelDB";
        final String mysqlUser = "root";
        final String mysqlPass = "mculli";

        Connection con = null;
        PreparedStatement stat = null;
        resultSet = null;

        try {
            // connection made to the database
            con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);

            // query is executed through a prepared statement and the ? is set as the value of QueryString
            stat = con.prepareStatement(QueryString);
            stat.setString(1, QueryString);

            // the query is executed and the result is put into resultSet
            resultSet = stat.executeQuery();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DbUtils.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return resultSet;

    }

}

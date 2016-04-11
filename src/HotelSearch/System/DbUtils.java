package HotelSearch.System;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by helgah on 16/03/16.
 */
public class DbUtils {

    public ResultSet SearchDB(List<String> queryList) {

        ResultSet resultSet;

        // info to connect to MySQL database
        final String mysqlUrl = "jdbc:mysql://localhost:3306/hotelDB?allowMultiQueries=true";
        final String mysqlUser = "root";
        final String mysqlPass = "mculli";

        Connection con = null;
        PreparedStatement stat1 = null;
        PreparedStatement stat2 = null;
        resultSet = null;

        try {
            // connection made to the database
            con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);


            if(queryList.get(1) != "") {
                stat2 = con.prepareStatement(queryList.get(1));
                stat2.executeUpdate();
            }

            stat1 = con.prepareStatement(queryList.get(0));
            resultSet = stat1.executeQuery();
            //stat.setString(1, QueryString);

            // the query is executed and the result is put into resultSet


        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DbUtils.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return resultSet;

    }

}

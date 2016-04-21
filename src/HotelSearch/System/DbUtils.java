package HotelSearch.System;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtils {
    // info to connect to MySQL database
    private static final String mysqlUrl = "jdbc:mysql://eu-cdbr-west-01.cleardb.com:3306/heroku_2a0df517779f4bb?allowMultiQueries=true";
    private static final String mysqlUser = "b4539441a655a0";
    private static final String mysqlPass = "3a6056ca";

    public ResultSet SearchDB(List<String> queryList) {
        ResultSet resultSet;

        Connection con = null;
        PreparedStatement stat1 = null;
        PreparedStatement stat2 = null;
        resultSet = null;

        //System.out.println(queryList.get(0));
        //System.out.println(queryList.get(1));

        try {
            // connection made to the database
            con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);

            if(queryList.get(1) != "") {
                stat2 = con.prepareStatement(queryList.get(1));
                stat2.executeUpdate();
            }

            stat1 = con.prepareStatement(queryList.get(0));
            // the query is executed and the result is put into resultSet
            resultSet = stat1.executeQuery();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DbUtils.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return resultSet;

    }

    public int updateDb(String sql) {
        int success = 0;
        Connection con = null;
        PreparedStatement stat;

        System.out.println(sql);

        try {
            con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);

            stat = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate();

            ResultSet set = stat.getGeneratedKeys();
            if (set.next())
                success = set.getInt(1);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DbUtils.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            return success;
        }
    }
}

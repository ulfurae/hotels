package HotelSearch.System;

import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

/**
 * Created by Halldor on 16/03/16.
 */
public class SqlMapper {

    public static <TOut> List<TOut> ToHotel(ResultSet rs) {
        try {
            while (rs.next()) {

            }
        } catch (SQLException e) {

        }

        return (List<TOut>) rs;
    }
}
package HotelSearch.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Ricky Hien on 23.3.2016.
 */
public class Review {
    private int id;
    public Hotel hotel;
    public String customerName;
    public Date date;
    public double rating;
    public String reviewText;

    public void toReview(ResultSet results) {
        try {
            while(results.next()) {

                id = results.getInt("id");
                rating = results.getDouble("rating");
                reviewText = results.getString("review");
                customerName = results.getString("customer_name");
                date = results.getDate("date");

                // TODO: Hotel - nota nafn eða id?

            }

        } catch (SQLException e) { e.printStackTrace(); }
    }
}

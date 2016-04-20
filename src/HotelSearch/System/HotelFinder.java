package HotelSearch.System;

import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelSearchFilter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HotelFinder {

    public List<Hotel> getHotels(HotelSearchFilter filter) {
        String din = new SimpleDateFormat("yyyy-MM-dd").format(filter.dateIn);
        String dout = new SimpleDateFormat("yyyy-MM-dd").format(filter.dateOut);

        List<String> sendList = new ArrayList<>();
        sendList.add(filter.areaName);
        sendList.add(din);
        sendList.add(dout);

        List<String> queryList = new QueryStringBuilder().makeSearchHotelsQuery(sendList);

        ResultSet results = new DbUtils().SearchDB(queryList);

        return new SqlMapper().mapHotelSearch(results);
    }

}

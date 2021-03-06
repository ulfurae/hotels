package HotelSearch.Tests;

import HotelSearch.Classes.Guest;
import HotelSearch.Classes.Hotel;
import HotelSearch.Classes.HotelSearchFilter;
import HotelSearch.Classes.QueryResolvers.HotelQueryResolver;
import HotelSearch.Classes.SqlCustomQuery;
import HotelSearch.System.QueryStringBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by halldorr on 30/03/16.
 */
public class QueryStringBuilderTests {

    private HotelQueryResolver resolver;
    private SqlCustomQuery query;

    private HotelSearchFilter filter1;
    private HotelSearchFilter filter2;
    private HotelSearchFilter filter3;
    private HotelSearchFilter threeNonDefaultValueFilter;
    private HotelSearchFilter emptyFilter;

    private Date dateIn;
    private Date dateOut;

    @Before
    public void setUp() throws Exception {
        resolver = new HotelQueryResolver();

        // create SQL dates for searchFilters
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(1990, 10, 13);
        dateIn = new Date(cal.getTimeInMillis());
        cal.set(2016, 3, 30);
        dateOut = new Date(cal.getTimeInMillis());

        // Initialize filter1, all fields are given a value
        filter1 = new HotelSearchFilter();
        filter1.wifi = true;
        filter1.smoking = true;
        filter1.breakfast = false;
        filter1.rating = 4.0;
        filter1.areaId = 2;
        filter1.dateIn = dateIn;
        filter1.dateOut = dateOut;

        // Initialize filter2, primitive type fields are given value
        filter2 = new HotelSearchFilter();
        filter2.wifi = true;
        filter2.smoking = true;
        filter2.breakfast = false;
        filter2.rating = 4.0;
        filter2.areaId = 2;

        // Initialize filter3, object type fields are given value
        filter3 = new HotelSearchFilter();
        filter3.dateIn = dateIn;
        filter3.dateOut = dateOut;

        // Initialize filter so exactly three fields are initialized to
        // their non default value, e.g. 0 for int is a default value
        threeNonDefaultValueFilter = new HotelSearchFilter();
        threeNonDefaultValueFilter.wifi = true;
        threeNonDefaultValueFilter.smoking = false;
        threeNonDefaultValueFilter.breakfast = false;
        threeNonDefaultValueFilter.areaId = 2;
        threeNonDefaultValueFilter.rating = 3.5;

        emptyFilter = new HotelSearchFilter();
    }

    @After
    public void tearDown() throws Exception {
        filter1 = null;
        filter2 = null;
        filter3 = null;
        threeNonDefaultValueFilter = null;
        emptyFilter = null;

        query = null;
        resolver = null;

        dateIn = null;
        dateOut = null;
    }

    @Test(expected = InvalidParameterException.class)
    public void filterIsNullShouldThrowError() throws Exception {
        query = QueryStringBuilder.getSQLQueryString(null, resolver);
    }

    @Test(expected = InvalidParameterException.class)
    public void resolverIsNullShouldThrowError() throws Exception {
        query = QueryStringBuilder.getSQLQueryString(new HotelSearchFilter(), null);
    }

    @Test
    public void allFieldsHaveValue() throws Exception {
        query = QueryStringBuilder.getSQLQueryString(filter1, resolver);

        String qString = "select * from Hotel where (`datein` >= ? and `dateout` <= ? and `wifi` = ? and `smoking` = ? and `rating` >= ? and `areaid` = ?)";
        List<Object >val = Arrays.asList(dateIn, dateOut, filter1.wifi, filter1.smoking, filter1.rating, filter1.areaId);

        assertEquals(val, query.values);
        assertEquals(qString, query.sqlStatement);
    }

    @Test
    public void primitiveFieldsHaveValue() throws Exception {
        query = QueryStringBuilder.getSQLQueryString(filter2, resolver);

        String qString = "select * from Hotel where (`wifi` = ? and `smoking` = ? and `rating` >= ? and `areaid` = ?)";
        List<Object> val = Arrays.asList(filter2.wifi, filter2.smoking, filter2.rating, filter2.areaId);

        assertEquals(val, query.values);
        assertEquals(qString, query.sqlStatement);
    }

    @Test
    public void objectFieldsHaveValue() throws Exception {
        query = QueryStringBuilder.getSQLQueryString(filter3, resolver);

        String qString = "select * from Hotel where (`datein` >= ? and `dateout` <= ?)";
        List<Object> val = Arrays.asList(dateIn, dateOut);

        assertEquals(val, query.values);
        assertEquals(qString, query.sqlStatement);
    }

    @Test
    public void numberOfConditionsMatchesNonDefaultValueFieldsInFilter() {
        query = QueryStringBuilder.getSQLQueryString(threeNonDefaultValueFilter, resolver);

        assertEquals(3, query.values.size());
    }

    @Test
    public void noFieldsHaveValueShoulReturnSelectAll() {
        query = QueryStringBuilder.getSQLQueryString(new HotelSearchFilter(), resolver);

        String qString = "select * from Hotel";

        assertEquals(qString, query.sqlStatement);
    }
}
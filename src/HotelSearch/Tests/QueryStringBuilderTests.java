package HotelSearch.Tests;

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
    }

    @After
    public void tearDown() throws Exception {
        filter1 = null;
        filter2 = null;
        filter3 = null;

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
        List<Object >val = Arrays.asList(dateIn, dateOut, true, true, 4.0, 2);

        assertEquals(val, query.values);
        assertEquals(qString, query.sqlStatement);
    }

    @Test
    public void primitiveFieldsHaveValue() throws Exception {
        query = QueryStringBuilder.getSQLQueryString(filter2, resolver);

        String qString = "select * from Hotel where (`wifi` = ? and `smoking` = ? and `rating` >= ? and `areaid` = ?)";
        List<Object> val = Arrays.asList(true, true, 4.0, 2);

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
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import static org.hamcrest.CoreMatchers.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jarmo
 */
public class SearchFlightFacadeTest {

    public SearchFlightFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWithOriginDate method, of class SearchFlightFacade.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetWithOriginDate() throws Exception {
        System.out.println("getWithOriginDate");
        String origin = "CPH";
        String date = "2017-01-23T00:00:00.000Z";
        int tickets = 1;
        SearchFlightFacade instance = new SearchFlightFacade();
        String result = instance.getWithOriginDate(origin, date, tickets);
        Assert.assertThat(result, containsString(origin));
    }

    /**
     * Test of getWithAllParam method, of class SearchFlightFacade.
     */
    @Test
    public void testGetWithAllParam() throws Exception {
        System.out.println("getWithAllParam");
        String origin = "CPH";
        String dest = "STN";
        String date = "2017-01-13T00:00:00.000Z";
        int tickets = 1;
        SearchFlightFacade instance = new SearchFlightFacade();
        String expResult = "";
        String result = instance.getWithAllParam(origin, dest, date, tickets);
        Assert.assertThat(result, containsString(dest));
    }

}

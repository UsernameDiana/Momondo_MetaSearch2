/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author jarmo
 */
public class SearchFlightResourceTest {

    public SearchFlightResourceTest() {
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
     * Test of getWithOriginDate method, of class SearchFlightResource.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetWithOriginDate() throws Exception {
        RestAssured.given()
                .pathParam("origin", "CPH")
                .pathParam("date", "2017-01-13T00:00:00.000Z")
                .pathParam("tickets", 1)
                .when()
                .get("http://airline-plaul.rhcloud.com/api/flightinfo/{origin}/{date}/{tickets}")
                .then()
                .body("flights.origin", hasItems("CPH"));
    }

    /**
     * Test of getWithAllParam method, of class SearchFlightResource.
     */
    @Test
    public void testGetWithAllParam() throws Exception {
        RestAssured.given()
                .pathParam("origin", "CPH")
                .pathParam("destination", "SXF")
                .pathParam("date", "2017-01-13T00:00:00.000Z")
                .pathParam("tickets", 1)
                .when()
                .get("http://airline-plaul.rhcloud.com/api/flightinfo/{origin}/{destination}/{date}/{tickets}")
                .then()
                .body("flights.origin", hasItems("CPH"));
    }

}

package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetTest {

    @BeforeAll
    public static void init(){
        baseURI = "http://54.144.125.207:8000";
    }

   /*TASK
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charset=UTF-8
    */

    @DisplayName("SpartanNegativeGetTest")
    @Test
    public void tes1(){

        Response response = given().accept(ContentType.XML).when().get("/api/spartans/10");

        assertEquals(406,response.statusCode());

        assertEquals("application/xml;charset=UTF-8",response.contentType());
    }


}

package com.cydeo.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanTestsWithParameters {

    @BeforeAll
    public static void init(){
        baseURI = "http://54.144.125.207:8000";
    }

     /*   Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Blythe" should be in response payload
       */

    @DisplayName("GET request to /api/spartans/{id} with id 5")
    @Test
    public void test1(){
        /*
                            //Given accept type is Json
        Response response = given().accept(ContentType.JSON)
                //And Id parameter value is 5
                //When user sends GET request to /api/spartans/{id}
                .when().get("/api/spartans/5");

         */

        Response response = given().
                                    accept(ContentType.JSON)
                                    .and().pathParam("id", 5)
                            .when()
                                    .get("/api/spartans/{id}");

        //Then response status code should be 200
        assertEquals(200,response.statusCode());

        //And response content-type: application/json
        assertEquals("application/json",response.contentType());

        //And "Blythe" should be in response payload
        assertTrue(response.body().asString().contains("Blythe"));

    }

     /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */

    @DisplayName("GET request to /api/spartans/{id} with id 500")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON).
                                    and().pathParam("id", 500).
                                    when().get("to /api/spartans/{id}");

        assertEquals(404,response.statusCode());

        assertEquals("application/json",response.contentType());

        assertTrue(response.body().asString().contains("Not Found"));
    }

    /*
        Given accept type is Json
        And query parameter values are:
        gender|Female
        nameContains|e
        When user sends GET request to /api/spartans/search ---> we found (search) that structure from the documentation
        Then response status code should be 200
        And response content-type: application/json
        And "Female" should be in response payload
        And "Janette" should be in response payload
     */

    @DisplayName("GET request to /api/spartans/search with Query Params")
    @Test
    public void test3(){

        Response response = given().accept(ContentType.JSON)
                                   .and().queryParam("gender","Female")
                                          .queryParam("nameContains","e")
                                     .get("/api/spartans/search");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));


    }

    @DisplayName("GET request to /api/spartans/search with Query Params (MAP)")
    @Test
    public void test4() {
        //create a map and add query parameters
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("gender","Female");
        queryMap.put("nameContains","e");


        Response response = given().log().all().
                            and().queryParams(queryMap).get("/api/spartans/search");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));
    }

}

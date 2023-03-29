package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

public class HrGetRequest {

    //BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.144.125.207:1000/ords/hr";
    }

    @DisplayName("GET request to /regions")
    @Test
    public void test1(){

        Response response = get("/regions");

        //print the status code
        System.out.println(response.statusCode());

    }

    /*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains   Americas
     */

    @Test
    public void test2(){
        //Given accept type is application/json
        //When user sends get request to /regions/2
        Response response = RestAssured.given().accept("application/json").when().get("/regions/2");

        //Then response status code must be 200
        Assertions.assertEquals(200, response.statusCode());

        //and content type equals to application/json
        Assertions.assertEquals("application/json", response.contentType());

        //and response body contains   Americas
        Assertions.assertTrue(response.body().asString().contains("Americas"));

    }

}

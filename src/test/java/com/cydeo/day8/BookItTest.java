package com.cydeo.day8;

import com.cydeo.utilities.BookItUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class BookItTest {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

    }

    //create BookItUtil then create a method, that accepts email and
    // password return token Bearer +yourToken as a String
    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";
    @DisplayName("GET all campuses")
    @Test
    public void testAuth1() {
        //how to pass bearer token for bookit ? use header method to give as key value header
        given().header("Authorization",accessToken)
                .accept(ContentType.JSON)
                .when().get("/api/campuses")
                .then().statusCode(200).log().all();

       // System.out.println(BookItUtil.accesToken("blyst6@si.edu","barbabaslyst"));
    }
}

package com.cydeo.day4;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestWithPath extends HrTestBase {

    @DisplayName("GET request to countries with path method")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\":2}")
                .when().get("/countries");

        //response.prettyPrint();

        assertEquals(200, response.statusCode());

        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first CountryId
        String firstCountryId= response.path("items[0].country_id");
        System.out.println("firstCountryId = " + firstCountryId);

        //print second countryname
        String secondCountryName = response.path("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);
        
        //print http://54.144.125.207:1000/ords/hr/countries/CA
        String linkCA = response.path("items[2].links[0].href");
        System.out.println("linkCA = " + linkCA);

        //get me all country names
        List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);


    }

}

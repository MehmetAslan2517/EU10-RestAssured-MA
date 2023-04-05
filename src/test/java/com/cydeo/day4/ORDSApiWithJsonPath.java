package com.cydeo.day4;

import com.cydeo.utilities.HrTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath extends HrTestBase {

    @DisplayName("GET request to countries")
    @Test
    public void test1(){

        Response response = get("/countries");

        //get the scond country name with jsonpath

        // to use jsonpath we assign response to jsonpath
        JsonPath jsonPath = response.jsonPath();
        String secondCountryName = jsonPath.getString("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        //get all country ids
        List<Object> allCountriesIDs = jsonPath.getList("items.country_id");
        System.out.println("allCountriesIDs = " + allCountriesIDs);

        //get all country names where their region id is equal to 2
        //it means each region id if it is 2 please retrieve country_name
        List<Object> countryNameWithRegionId2 = jsonPath.getList("items.findAll {it.region_id==2}.country_name");


    }


    @DisplayName("GET request to employees with query param")
    @Test
    public void test2(){
        //we added limit query param to get 107 employees
        Response response = given().queryParam("limit",107)
                .when().get("/employees");

        // get me all email of employees who is working as IT_PROG
        JsonPath jsonPath = response.jsonPath();
        List<String> emailsOfIT_PROG = jsonPath.getList("items.findAll{it.job_id==\"IT_PROG\"}.email");
        System.out.println("emailsOfIT_PROG = " + emailsOfIT_PROG);

        //get me first name of employees who is making 10000

        List<String> firstNamesOf10000salary = jsonPath.getList("items.findAll{it.salary>10000}.first_name");
        System.out.println("firstNamesOf10000salary = " + firstNamesOf10000salary);
        //String nameOfEMp = firstNamesOf10000salary.get(0);
        //System.out.println("nameOfEMp = " + nameOfEMp);

        //get the max salary first name
        String kingFirstName = jsonPath.getString("items.max {it.salary}.first_name");
        String kingNameWtihPathMethod = response.path("items.max {it.salary}.first_name");
        System.out.println("kingFirstName = " + kingFirstName);
        System.out.println("kingNameWtihPathMethod = " + kingNameWtihPathMethod);
    }

}

package com.cydeo.utilities;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BookItUtil extends BookItTestBase{
    //create BookItUtil then create a method, that accepts email and
    // password return token Bearer +yourToken as a String
    /*
    @DisplayName("ascsdc")
    @Test
    public static String accesToken(String email,String password){



        String accessToken = given().header("Authorization",accessToken)
                        .accept(ContentType.JSON)
                        .when().get("/api/campuses")
                        .then().statusCode(200)
                .extract().jsonPath().getString("accessToken");
        return accessToken;

    }
*/

}

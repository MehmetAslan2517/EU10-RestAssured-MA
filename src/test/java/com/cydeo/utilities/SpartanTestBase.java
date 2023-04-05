package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartanTestBase {

    @BeforeAll
    public static void init(){
        baseURI = ConfigurationReader.getProperty("spartanBaseURL");

        //we need to connect DB, so we use DBUtils.createConnection() method
        //later we can use ConfigurationReader for dbUrl,dbUsername,dbPassword
       // String dbUrl = "jdbc:oracle:thin:@54.144.125.207:1521:XE";
       // String dbUsername = "SP";
       // String dbPassword = "SP";

       // DBUtils.createConnection(dbUrl,dbUsername,dbPassword);

        DBUtils.createConnection(ConfigurationReader.getProperty("spartanDbUrl"),
                ConfigurationReader.getProperty("spartanDbUsername"),
                ConfigurationReader.getProperty("spartanDbPassword"));
    }

    @AfterAll
    public static void teardown(){
        DBUtils.destroy();
    }

}

package qa.automation.group;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostBooks {

    @BeforeTest
    public void postAuth() {

        int code = RestAssured.given()
                .auth().preemptive()
                .basic("admin1", "test")
                .when()
                .post("http://localhost:8080/books")
                .getStatusCode();
        System.out.println("Response Code from server is" + code);

    }


     @Test
     public void insertBooks(){

        given()
              .contentType("application/json")
              .body("{  \"author\": \"Graciliano Ramos\",  " +
                      "\"bookCategory\": \"Romance\",  " +
                      "\"id\": 0,  " +
                      "\"title\": \"Grande Sertão Veredas\"}")
        .when()
              .post("http://localhost:8080/books")
        .then()
              .statusCode(201)
              .log().all();
    }

}
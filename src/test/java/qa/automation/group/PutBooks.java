package qa.automation.group;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutBooks {

    @Test
    public void putAuth() {

        int code = given()
                .auth().preemptive()
                .basic("admin1", "test")
                .when()
                .put("http://localhost:8080/books")
                .getStatusCode();
        System.out.println("Response Code from server is" + code);
    }


    @Test
    public void alterBooks() {
        given()
                .contentType("application/json")
                .body("{  \"author\": \"Graciliano Ramos\",  " +
                        "\"bookCategory\": \"Romance\",  " +
                        "\"id\": 8,  " +
                        "\"title\": \"Grande Sertão Veredas\"}")
                .when()
                .put("http://localhost:8080/books")
                .then()
                .statusCode(201)
                .log().all();

    }

}


package qa.automation.group.requests.failed;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static qa.automation.group.utils.FileUtils.readJson;

public class TestBooksFailed {
    @BeforeTest
    void setup(){
        baseURI = "http://localhost";
        port = 8080;
    }

    @Test
    void searchBooks_shouldReturnUnauthorized_whenPasswordIncorrect() {

        given()
            .contentType("application/json")
            .auth()
            .preemptive()
            .basic("admin1", "tes")
            .when()
            .get("/books")
            .then()
            .statusCode(401)
            .log().all();

    }


    @Test
    void alterBooks() throws IOException {
        String jsonBody = readJson("db/books2.json");


        given()
            .contentType("application/json")
            .body(jsonBody)
            .auth()
            .preemptive()
            .basic("admin1", "tt")
            .when()
            .post("/books")
            .then()
            .statusCode(401)
            .log().all();


    }

}

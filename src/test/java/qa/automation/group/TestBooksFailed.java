package qa.automation.group;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class TestBooksFailed {
    @BeforeTest
    void setup(){
        baseURI = "http://localhost";
        port = 8080;
    }

    @Test
    void searchBooks() {

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

    private String readJson(String pathJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(pathJson)));
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

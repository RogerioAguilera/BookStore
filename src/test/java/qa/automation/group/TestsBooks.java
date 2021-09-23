package qa.automation.group;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestsBooks {

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
            .basic("admin1", "test")
            .when()
            .get("/books")
            .then()
            .statusCode(200)
            .log().all();

    }

    private String readJson(String pathJson) throws IOException{
        return new String(Files.readAllBytes(Paths.get(pathJson)));
    }

    @Test
    void InsertBooks() throws IOException {
        String jsonBody = readJson("db/books1.json");


        given()
            .contentType("application/json")
            .body(jsonBody)
            .auth()
            .preemptive()
            .basic("admin1", "test")
            .when()
            .post("/books")
            .then()
            .statusCode(201)
            .log().all();


    }

    @Test
    void alterBooks() {

        given()
            .contentType("application/json")
            .body("{\n" +
                "  \"author\": \"Jack London\",\n" +
                "  \"bookCategory\": \"Aventura\",\n" +
                "  \"id\": 21,\n" +
                "  \"title\": \"O chamado da floresta\"\n" +
                "}")
            .auth()
            .preemptive()
            .basic("admin1", "test")
            .when()
            .put("/books")
            .then()
            .statusCode(200)
            .log().all();


    }

    @Test
    void deleteBooks() {
        given()
            .contentType("application/json")
            .auth()
            .preemptive()
            .basic("admin1", "test")
            .when()
            .delete("/books/19")
            .then()
            .statusCode(204)
            .log().all();


    }
}



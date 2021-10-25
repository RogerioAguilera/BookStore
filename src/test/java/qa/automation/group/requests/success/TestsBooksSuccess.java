package qa.automation.group.requests.success;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static qa.automation.group.utils.FileUtils.readJson;

public class TestsBooksSuccess {

    private static final String user = System.getenv("USER");
    private static final String pass = System.getenv("PASS");

    @BeforeTest
    void setup() {
        baseURI = "http://localhost";
        port = 8080;
    }

    @Test
    void searchBooks() {

        given()
            .contentType("application/json")
            .auth()
            .preemptive()
            .basic(user, pass)
            .when()
            .get("/books")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    void searchBooksId() {
        given()
            .contentType("application/json")
            .auth()
            .preemptive()
            .basic(user, pass)
            .when()
            .get("/books/54")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    void InsertBooks() throws IOException {
        String jsonBody = readJson("db/books1.json");

        given()
            .contentType("application/json")
            .body(jsonBody)
            .auth()
            .preemptive()
            .basic(user, pass)
            .when()
            .post("/books")
            .then()
            .statusCode(201)
            .log().all();
    }

    @Test
    void alterBooks() throws IOException {
        String jsonBody = readJson("db/books1.json");

        given()
            .contentType("application/json")
            .body(jsonBody)
            .auth()
            .preemptive()
            .basic(user, pass)
            .when()
            .post("/books")
            .then()
            .statusCode(400)
            .log().all();
    }

    @Test
    void deleteBooks() {
        given()
            .contentType("application/json")
            .auth()
            .preemptive()
            .basic(user, pass)
            .when()
            .delete("/books/53")
            .then()
            .statusCode(400)
            .log().all();
    }

    @Test
    void deleteBooksId() {
        given()
            .contentType("application/json")
            .auth()
            .preemptive()
            .basic(user, pass)
            .when()
            .delete("/books/28")
            .then()
            .statusCode(204)
            .log().all();
    }
}

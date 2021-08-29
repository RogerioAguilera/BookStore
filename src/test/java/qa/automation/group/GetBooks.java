package qa.automation.group;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooks {

    @Test
    public void searchBooks(){

        ValidatableResponse code =
                given()
                        .contentType("application/json")
                        .auth()
                        .preemptive()
                        .basic("admin1", "test")
                        .when()
                        .get("http://localhost:8080/books")
                        .then()
                        .statusCode(200)
                        .log().all();

    }

}

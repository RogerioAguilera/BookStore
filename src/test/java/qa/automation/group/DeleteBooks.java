package qa.automation.group;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooks {

    @Test
    public void deleteBooks(){
        ValidatableResponse code =
                given()
                        .contentType("application/json")
                        .auth()
                        .preemptive()
                        .basic("admin1", "test")
                        .when()
                        .delete("http://localhost:8080/books/15")
                        .then()
                        .statusCode(204)
                        .log().all();


    }
}

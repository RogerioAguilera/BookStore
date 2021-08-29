package qa.automation.group;


import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostBooks {

    @Test
    public void InsertBooks() {

        ValidatableResponse code =
                given()
                        .contentType("application/json")
                .body("{  \"author\": \"H. Rider Haggard\",  " +
                        "\"bookCategory\": \"Ficção\",  " +
                        "\"title\": \"As minas do Rei Salomão\"}")
                .auth()
                        .preemptive()
                        .basic("admin1", "test")
                .when()
                        .post("http://localhost:8080/books")
                .then()
                        .statusCode(201)
                .log().all();


    }

}

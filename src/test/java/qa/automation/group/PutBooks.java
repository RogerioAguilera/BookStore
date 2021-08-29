package qa.automation.group;


import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutBooks {

    @Test
    public void alterBooks() {
        ValidatableResponse code =
                given()
                        .contentType("application/json")
                        .body("{\n" +
                                "  \"author\": \"Jack London\",\n" +
                                "  \"bookCategory\": \"Aventura\",\n" +
                                "  \"id\": 13,\n" +
                                "  \"title\": \"O chamado da floresta\"\n" +
                                "}")
                        .auth()
                        .preemptive()
                        .basic("admin1", "test")
                        .when()
                        .put("http://localhost:8080/books")
                        .then()
                        .statusCode(204)
                        .log().all();


    }

}



package qa.automation.group;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooks {

    @Test
    public void deleteAuth(){
        int code = given()
                .auth().preemptive()
                .basic("admin1", "test")
                .when()
                .delete("http://localhost:8080/books")
                .getStatusCode();
        System.out.println("Response Code from server is" + code);


    }

    @Test
    public void apagarDados(){
        given()
                .contentType("application/json")
                .body("{  \"author\": \"Graciliano Ramos\",  " +
                        "\"bookCategory\": \"Romance\",  " +
                        "\"id\": 8,  " +
                        "\"title\": \"Grande Sertão Veredas\"}")
                .when()
                .delete("http://localhost:8080/books")
                .then()
                .statusCode(200)
                .log().all();
    }
}

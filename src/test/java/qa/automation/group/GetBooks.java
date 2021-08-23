package qa.automation.group;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetBooks {

    @BeforeTest
    public void getAuth(){

        int code= RestAssured.given()
        .auth().preemptive()
        .basic("admin1","test")
        .when()
        .get("http://localhost:8080/books")
        .getStatusCode(200);

        System.out.println("Response Code from server is"+code);

    }

}

package qa.automation.group;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetBooksTest {

    @Test
    public void autenticarTest(){

        int code= RestAssured.given()
        .auth().preemptive()
        .basic("admin1","test")
        .when("localhost:8080/books")
        .getStatusCode();

        System.out.println("Response Code from server is"+code);

    }

}

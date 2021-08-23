package qa.automation.group;

public class GetBooksTest {

    public void autenticarTest(){

        int code=RestAssured.given()
        .auth().preemptive()
        .basic("admin1","test")
        .when("localhost:8080/books")
        .getStatusCode();

        System.out.println("Response Code from server is"+code);

    }

}

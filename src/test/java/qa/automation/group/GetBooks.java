package qa.automation.group;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBooks {
    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:8080";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET,"/books");

    }


}

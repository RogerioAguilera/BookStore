package qa.automation.group;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

public class PostBooks {

    @Test
    public void autenticarUser(){
        RestAssured.baseURI = "http://localhost:8080";

        RequestSpecification request = RestAssured.given();

        String credentials = "admin1:test";

       byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());

       String encodedCredentialsString = new String(encodedCredentials);

       request.header("Authorization","Basic "+encodedCredentialsString);

       String payload = "{  \"author\": \"Monteiro Lobato\",  " +
               "\"bookCategory\": \"Infantil\",  " +
               "\"id\": 0,  " +
               "\"title\": \"Menino Maluquinho\"}";



       request.header("Content-Type","application/json");

       Response response = request.body(payload).post("/books");

        System.out.println("Response Status Code is "+response.getStatusCode());

        response.prettyPrint();

    }
}

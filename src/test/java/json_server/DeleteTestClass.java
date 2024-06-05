package json_server;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTestClass {
    @Test
    public void deleteTest1(){
        Response response = given().when().delete("http://localhost:3000/comments/1");
        response.prettyPrint();
    }
}

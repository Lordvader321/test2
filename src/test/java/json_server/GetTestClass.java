package json_server;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetTestClass {
    @Test
    public void firstGetTest(){
        Response response = given().get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void secondGetTest(){
        Response response = given().get("http://localhost:3000/comments/1");
        response.prettyPrint();
        String textResponse = response.then().extract().path("text");
        //System.out.println(textResponse);
        Assert.assertEquals(textResponse,"a comment about post 1");


    }
    @Test
    public void thirdGetTest(){
        Response response = given().get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().statusCode(200);
        List<String> titles = response.then().extract().path("title");
        titles.forEach(t -> System.out.println(t));


    }
}

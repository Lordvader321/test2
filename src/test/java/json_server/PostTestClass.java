package json_server;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.xml.stream.events.Comment;

import static io.restassured.RestAssured.given;

public class PostTestClass {

    @Test
    public void PostTest1(){
        String postBody = "{\n" +
                "      \"id\": \"1\",\n" +
                "      \"text\": \"a comment about post 1\",\n" +
                "      \"postId\": \"1\"\n" +
                "    }";
        Response response = given().header("Contest-type", "applicatiom/json")
                .body(postBody).post("http://localhost:3000/comments");
        response.prettyPrint();

    }


    }


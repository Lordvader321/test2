package json_server.employees;

import employees.Employee;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DeleteEmployeesTest {
    @Test
    public void deleteTest1(){
        given().delete("http://localhost:3000/employees/2");

        Response response = given().get("http://localhost:3000/employees");
        List<String> ids = response.then().extract().path("id");
        boolean idPresent = false;

        for (String id: ids ) {
            if(id.equalsIgnoreCase("2"))
                idPresent = true;
        }

        Assert.assertFalse(idPresent);

    }
}

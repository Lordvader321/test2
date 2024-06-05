package json_server.employees;


import com.fasterxml.jackson.databind.ObjectMapper;
import employees.Employee;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetEmployeesTest {
    @Test
    public void getTest1(){
        Response response = given().when().get("http://localhost:3000/employees");
       // response.prettyPrint();
        List<String> street = response.then().extract().path("address.street");
        System.out.println(street);
    }
    @Test
    public void getTest2(){
        Response response = given().when().get("http://localhost:3000/employees");
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employees = Arrays.asList(response.getBody().as(Employee[].class));
        System.out.println(employees.get(0).getDept().getName()+"**********");

        }
        @Test
    public void getTest3(){
        Response response = given().when().get("http://localhost:3000/employees");
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employees = Arrays.asList(response.getBody().as(Employee[].class));
        System.out.println(employees.get(0).getAddress().getZip()+ " zipcode");
        Integer adress = employees.get(0).getAddress().getZip();
            Assert.assertEquals(adress, 12345);

        }
    }




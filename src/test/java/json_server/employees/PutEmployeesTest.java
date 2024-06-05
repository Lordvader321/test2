package json_server.employees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import employees.Address;
import employees.Dept;
import employees.Employee;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.xml.stream.events.Comment;

import static io.restassured.RestAssured.given;

public class PutEmployeesTest {
    @Test
    public void putTest1(){
        Address address = new Address();
        address.setCity("365");
        address.setState("Nyc");
        address.setZip(54321);
        address.setStreet("jamaica");

        Dept dept = new Dept();
        dept.setId(2);
        dept.setBuilding("15-b");
        dept.setName("Accounting");

        Employee employee = new Employee();
        employee.setId("2");
        employee.setFirstName("ABC");
        employee.setLastName("DEF");
        employee.setPhone(929312);
        employee.setAddress(address);
        employee.setDept(dept);

        ObjectMapper mapper = new ObjectMapper();
        String object;
        try {
            object = mapper.writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Response response = given().header("Content-type", "application/json")
           .body(employee).put("http://localhost:3000/employees/2");
    response.prettyPrint();

    }
}

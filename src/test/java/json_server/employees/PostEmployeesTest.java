package json_server.employees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import employees.Address;
import employees.Dept;
import employees.Employee;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostEmployeesTest {
    @Test
    public void postTest(){
        Address address = new Address();
        address.setCity("365");
        address.setState("Nyc");
        address.setZip(11432);
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

        Response response = given().header("Content-Type", "application/json")
                .body(object).when().post("http://localhost:3000/employees");


    }


}

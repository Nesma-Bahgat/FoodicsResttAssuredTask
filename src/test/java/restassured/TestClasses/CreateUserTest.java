package restassured.TestClasses;

import restassured.BaseTest.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restassured.TestData.TestData;
import restassured.model.Constants;
import restassured.model.UserRequestPayload;

public class CreateUserTest extends BaseTest {
    
    @Test 
    public void createUserType() throws JsonProcessingException {

        UserRequestPayload user = new UserRequestPayload(TestData.userName, TestData.userJob);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(user);
        Response response = given()
                .header(Constants.contentTypeHeader, Constants.applicationTypeValue)
                .body(requestBody)
                .post(Constants.UserAPIEndpoint);

        String newUserID = response.then().extract().path("id");
        TestData.setUserId(newUserID);

        System.out.println("Request: " + requestBody);
        System.out.println("Response: " + response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(response.jsonPath().getString("name"), user.getName());
        Assert.assertEquals(response.jsonPath().getString("job"), user.getJob());
    }
    
    @Test
    public void errorHandlingUserwithEmptyData() throws JsonProcessingException{
        
        UserRequestPayload user = new UserRequestPayload("","");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(user);
        Response response = given()
                .header(Constants.contentTypeHeader, Constants.applicationTypeValue)
                .body(requestBody)
                .post(Constants.UserAPIEndpoint);

        System.out.println("Request: " + requestBody);
        System.out.println("Response: " + response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(),400,"Required Parameters can not be empty");
    }
    
}

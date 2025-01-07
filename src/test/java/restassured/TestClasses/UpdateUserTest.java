
package restassured.TestClasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restassured.BaseTest.BaseTest;
import restassured.TestData.TestData;
import restassured.model.Constants;
import restassured.model.UserRequestPayload;

public class UpdateUserTest extends BaseTest{
    
    @Test
    public void updateUserTest() throws JsonProcessingException{
        
        UserRequestPayload user = new UserRequestPayload(TestData.updatedUserName, TestData.updatedUserJob);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(user);
        Response response = given()
                .header(Constants.contentTypeHeader, Constants.applicationTypeValue)
                .body(requestBody)
                .put(Constants.UserAPIEndpoint+"/"+TestData.getUserId());
                //.put(Constants.updateUserAPIEndpoint);
                System.out.println("UserId:" + TestData.getUserId());
        String newUserID = response.then().extract().path("id");
        TestData.setUserId(newUserID);

        System.out.println("Request: " + requestBody);
        System.out.println("Response: " + response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), user.getName());
        Assert.assertEquals(response.jsonPath().getString("job"), user.getJob());
    }
}
    
    
    


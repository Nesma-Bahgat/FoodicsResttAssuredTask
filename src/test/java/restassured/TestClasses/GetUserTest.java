
package restassured.TestClasses;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restassured.BaseTest.BaseTest;
import restassured.TestData.TestData;
import restassured.model.Constants;

public class GetUserTest extends BaseTest {
    
    @Test
    public void getUserData(){
        //The below code is commented due to an error in the system, System does not save the new created users 
        //And another example with an existing user is written below
        
    /*  Response response = RestAssured.get(Constants.UserAPIEndpoint+"/"+TestData.getUserId());
        Assert.assertEquals(response.getStatusCode(), 200,"user is not found");
        
        Assert.assertEquals(response.jsonPath().get("data.id").toString(),TestData.getUserId());
        Assert.assertEquals(response.jsonPath().getString("data.first_name"),TestData.userName);
        System.out.println(response.body().prettyPrint());*/
    
    Response response = RestAssured.get(Constants.UserAPIEndpoint+"/"+TestData.userID);
        Assert.assertEquals(response.getStatusCode(), 200);
        
        Assert.assertEquals(response.jsonPath().get("data.id").toString(),"2");
        Assert.assertEquals(response.jsonPath().getString("data.first_name"),"Janet");
        System.out.println(response.body().prettyPrint());
    }
    
    @Test
    public void errorhandlingNonExistingUser(){
        Response response = RestAssured.get("/api/users/200");
        Assert.assertEquals(response.getStatusCode(), 404);
        
    }
    
}

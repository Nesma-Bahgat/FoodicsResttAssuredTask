
package restassured.BaseTest;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import restassured.model.Constants;
import restassured.utils.ConfigReaders;

public class BaseTest {
   
    
    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = ConfigReaders.getProperty("baseURI") ; 
    }
}


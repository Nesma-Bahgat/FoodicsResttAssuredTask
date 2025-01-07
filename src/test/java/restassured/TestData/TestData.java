
package restassured.TestData;

public class TestData {
    
     private static String userId ;
     public static final String userName = "Test Name";
     public static String userJob = "Software Engineer";
     public static final String updatedUserName = "Updated Name";
     public static String updatedUserJob = "Updated Job";
     public static String userID = "2";

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String id) {
        userId = id;
    }
}

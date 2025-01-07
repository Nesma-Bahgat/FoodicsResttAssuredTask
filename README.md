* Project structed with multi folders for different actions as follows:
1-main/java/restassured/model: Java classes contains all constants values used in the test && Request body for poost and put APIs
2-main/java/restassured/utils: Java class for reading the configuration file
3-main/java/resources/ConfigurationAndProperties: contains all needed congiuration data for executing tests
4-test/java/restassured/BaseTest: Java class for setting up tests
5-test/java/restassured/Listenrs: Java class for test listeners to log any errors
6-test/java/restassured/TestClasses: Java classes for all test classes
7-test/java/restaaured/TestData: Java class for all test data used in test classes
* Project Contains a testNG file  and should be run through it to run all test classes.
* For test Class "GetUserData":
  1. The Reqres API does not have a backend database to persist data between requests. Instead, when you send a POST request, it simply simulates the creation of an object by returning the data you sent, along with a mock id.
2. The object is not stored anywhere, so when you send a subsequent GET request, it will not include the previously "created" object.

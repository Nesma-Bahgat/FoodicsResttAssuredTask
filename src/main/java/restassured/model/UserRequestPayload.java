package restassured.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequestPayload {

    @JsonProperty("name")  // Map to JSON field "name"
    private String name;
    
    @JsonProperty("job")  // Map to JSON field "name"
    private String job;

    public UserRequestPayload(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }
}

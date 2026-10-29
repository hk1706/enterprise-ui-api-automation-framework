package api.models;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocalUser {

    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getJob(){
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

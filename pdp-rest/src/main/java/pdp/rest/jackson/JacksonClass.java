package pdp.rest.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class JacksonClass {

    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private Integer height;

    @JsonProperty("salaryUSD")
    private Double salary;
    private List<JacksonClass> friends;

    public JacksonClass() {
        friends = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<JacksonClass> getFriends() {
        return friends;
    }

    public void setFriends(List<JacksonClass> friends) {
        this.friends = friends;
    }

    public void addFriend(JacksonClass friend) {
        if(this.friends != null) {
            this.friends.add(friend);
        }
    }
}

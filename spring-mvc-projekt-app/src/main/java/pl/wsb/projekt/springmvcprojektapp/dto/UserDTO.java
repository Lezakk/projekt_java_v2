package pl.wsb.projekt.springmvcprojektapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;

import java.util.Set;

public class UserDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("lists")
    private Set<ToDoList> lists;;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ToDoList> getLists() {
        return lists;
    }

    public void setLists(Set<ToDoList> lists) {
        this.lists = lists;
    }
}

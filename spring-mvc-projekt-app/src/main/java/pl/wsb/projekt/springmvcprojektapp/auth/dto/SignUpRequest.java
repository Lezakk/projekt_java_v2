package pl.wsb.projekt.springmvcprojektapp.auth.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import pl.wsb.projekt.springmvcprojektapp.model.Position;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;

import javax.validation.constraints.*;
import java.util.Set;

public class SignUpRequest {

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

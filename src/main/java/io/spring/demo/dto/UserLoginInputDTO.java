package io.spring.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLoginInputDTO {
    
    @NotBlank
    @Email
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}

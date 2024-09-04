package com.example.demo.bll.models.forms;

import com.example.demo.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

    private String username;

    private String email;

    private String firstname;

    private String lastname;

    private String password;

    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setEmail(this.email);
        user.setLastname(this.lastname);
        user.setFirstname(this.firstname);
        user.setPassword(this.password);
        return user;
    }
}

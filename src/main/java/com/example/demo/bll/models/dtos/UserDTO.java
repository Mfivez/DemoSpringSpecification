package com.example.demo.bll.models.dtos;

import com.example.demo.domain.entities.User;

public record UserDTO(
        String username,
        String email,
        String lastname,
        String firstname
) {
    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(), user.getLastname(), user.getFirstname());
    }
}

package com.example.demo.bll.specifications;

import com.example.demo.domain.entities.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class UserSpecification {

    public static Specification<User> hasUsername(String username) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("username")), "%" + username.toLowerCase() + "%");
    }

    public static Specification<User> hasEmail(String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

}
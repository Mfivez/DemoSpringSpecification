package com.example.demo.bll.specifications;

import com.example.demo.domain.entities.User;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;

public class UserSpecification {

    /**
     * Creates a {@link Specification} that filters users based on their username.
     * <p>
     * This method uses the {@link CriteriaBuilder} to create a {@link Predicate} that
     * represents the condition "username LIKE :username". The username is converted
     * to lowercase to make the search case-insensitive. The "%" wildcard characters are
     * used to perform a pattern match.
     * </p>
     *
     * @param username the username to search for. The search is case-insensitive and
     *                 matches any part of the username.
     * @return a {@link Specification} that can be used to filter {@link User} entities
     *         by username.
     */
    public static Specification<User> hasUsername(String username) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("username")), "%" + username.toLowerCase() + "%");
    }

    public static Specification<User> hasEmail(String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

}
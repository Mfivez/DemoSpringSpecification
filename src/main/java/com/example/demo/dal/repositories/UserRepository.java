package com.example.demo.dal.repositories;

import com.example.demo.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(
            "SELECT u " +
            "FROM User u " +
            "WHERE u.username LIKE CONCAT('%', :username, '%')")
    List<User> findByUsername(String username);

    @Query(
            "SELECT u " +
            "FROM User u " +
            "WHERE u.firstname LIKE CONCAT('%', :firstname, '%')")
    List<User> findByFirstname(String firstname);

    @Query(
            "SELECT u " +
            "FROM User u " +
            "WHERE u.lastname LIKE CONCAT('%', :lastname, '%')")
    List<User> findByLastname(String lastname);

    @Query(
            "SELECT u " +
            "FROM User u " +
            "WHERE LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))")
    List<User> findByEmail(@Param("email") String email);
}

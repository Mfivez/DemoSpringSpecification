package com.example.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User extends BaseEntity<Long>{

    @Column(name = "username")
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;


    @OneToMany(mappedBy = "user")
    private List<FriendShip> friendships;


    public User() {
        this.posts = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.friendships = new ArrayList<>();
    }
}

/// Visu d'une page et c'est à toi de lui dire ce qu'il va devoir ajouter pour créer un utilisateur:
//  Formulaire : username, email, lastname, firstname, password
package com.example.demo.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "post")
public class Post extends BaseEntity<Long>{

    @Column(name = "content")
    private String content;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    public Post() {
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

}

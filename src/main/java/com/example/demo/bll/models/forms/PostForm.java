package com.example.demo.bll.models.forms;

import com.example.demo.dal.repositories.UserRepository;
import com.example.demo.domain.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PostForm {
    private String content;
    private Long userId;
    private LocalDateTime creationDate;

    private final UserRepository userRepo;

    public Post toEntity() {
        Post post = new Post();
        post.setContent(this.content);
        post.setCreationDate(this.creationDate);
        post.setUser(userRepo.findById(userId).orElseThrow());
        return post;
    }
}

package com.example.demo.bll.models.dtos;

import com.example.demo.domain.entities.Post;

import java.time.LocalDateTime;

public record PostDTO (
        String content,
        LocalDateTime creationDate,
        Long userId
) {
    public static PostDTO fromEntity(Post post) {
        return new PostDTO(
                post.getContent(),
                post.getCreationDate(),
                post.getUser().getId()
        );
    }
}

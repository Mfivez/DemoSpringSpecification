package com.example.demo.bll.models.dtos;

import com.example.demo.domain.entities.Comment;

public record CommentDTO (
        String content,
        Long userId,
        Long postId
) {
    public static CommentDTO fromEntity(Comment comment) {
        return new CommentDTO(
                comment.getContent(),
                comment.getUser().getId(),
                comment.getPost().getId()
        );
    }
}
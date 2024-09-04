package com.example.demo.bll.models.dtos;

import com.example.demo.domain.entities.Like;

public record LikeDTO (
        Long userId,
        Long postId
) {
    public static LikeDTO fromEntity(Like like) {
        return new LikeDTO(
                like.getUser().getId(),
                like.getPost().getId()
        );
    }
}

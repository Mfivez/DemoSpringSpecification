package com.example.demo.bll.models.forms;

import com.example.demo.dal.repositories.PostRepository;
import com.example.demo.dal.repositories.UserRepository;
import com.example.demo.domain.entities.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class LikeForm {
    private Long userId;
    private Long postId;

    private final PostRepository postRepo;
    private final UserRepository userRepo;


    public Like toEntity() {
        Like like = new Like();
        like.setPost(postRepo.findById(postId).orElseThrow());
        like.setUser(userRepo.findById(userId).orElseThrow());
        return like;
    }

}

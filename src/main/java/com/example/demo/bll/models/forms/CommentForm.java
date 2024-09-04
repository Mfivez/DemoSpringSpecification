package com.example.demo.bll.models.forms;

import com.example.demo.bll.services.impl.PostServiceImpl;
import com.example.demo.bll.services.impl.UserServiceImpl;
import com.example.demo.dal.repositories.PostRepository;
import com.example.demo.dal.repositories.UserRepository;
import com.example.demo.domain.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentForm {
    private String content;
    private Long userId;
    private Long postId;

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Comment toEntity() {
        Comment comment = new Comment();
        comment.setUser(userRepository.findById(userId).orElseThrow());
        comment.setContent(this.content);
        comment.setPost(postRepository.findById(postId).orElseThrow());
        return comment;
    }
}
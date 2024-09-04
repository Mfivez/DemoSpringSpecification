package com.example.demo.bll.services.impl;

import com.example.demo.bll.models.dtos.PostDTO;
import com.example.demo.bll.models.forms.PostForm;
import com.example.demo.bll.services.PostService;
import com.example.demo.dal.repositories.PostRepository;
import com.example.demo.domain.entities.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repo;

    @Override
    public PostDTO getOne(Long id) {
        Post post = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Post with id " + id + " doesn't exist."));
        return PostDTO.fromEntity(post);
    }

    @Override
    public List<PostDTO> getAll() {
        return repo.findAll().stream()
                .map(PostDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO addOne(PostForm form) {
        return PostDTO.fromEntity(repo.save(form.toEntity()));
    }

    @Override
    public PostDTO update(Long id, PostForm form) {
        Post existingPost = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Post with id " + id + " doesn't exist."));

        Post updatedPost = form.toEntity();
        existingPost.setUser(updatedPost.getUser());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setComments(updatedPost.getComments());

        return PostDTO.fromEntity(repo.save(existingPost));
    }

    @Override
    public PostDTO delete(Long id) {
        Post existingPost = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Post with id " + id + " doesn't exist."));
        repo.delete(existingPost);
        return PostDTO.fromEntity(existingPost);
    }
}
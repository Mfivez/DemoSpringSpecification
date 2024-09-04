package com.example.demo.bll.services.impl;

import com.example.demo.bll.models.dtos.CommentDTO;
import com.example.demo.bll.models.forms.CommentForm;
import com.example.demo.bll.services.CommentService;
import com.example.demo.dal.repositories.CommentRepository;
import com.example.demo.domain.entities.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repo;

    @Override
    public CommentDTO getOne(Long id) {
        Comment comment = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Comment with id " + id + " doesn't exist."));
        return CommentDTO.fromEntity(comment);
    }

    @Override
    public List<CommentDTO> getAll() {
        return repo.findAll().stream()
                .map(CommentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO addOne(CommentForm form) {
        return CommentDTO.fromEntity(repo.save(form.toEntity()));
    }

    @Override
    public CommentDTO update(Long id, CommentForm form) {
        Comment comment = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Comment with id " + id + " doesn't exist."));
        comment.setContent(form.getContent());

        return CommentDTO.fromEntity(repo.save(comment));
    }

    @Override
    public CommentDTO delete(Long id) {
        Comment existingComment = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Comment with id " + id + " doesn't exist."));
        repo.delete(existingComment);
        return CommentDTO.fromEntity(existingComment);
    }
}

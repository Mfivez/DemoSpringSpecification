package com.example.demo.bll.services.impl;

import com.example.demo.bll.models.dtos.LikeDTO;
import com.example.demo.bll.models.forms.LikeForm;
import com.example.demo.bll.services.LikeService;
import com.example.demo.dal.repositories.LikeRepository;
import com.example.demo.domain.entities.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository repo;

    @Override
    public LikeDTO getOne(Long id) {
        Like like = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Like with id " + id + " doesn't exist."));
        return LikeDTO.fromEntity(like);
    }

    @Override
    public List<LikeDTO> getAll() {
        return repo.findAll().stream()
                .map(LikeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public LikeDTO addOne(LikeForm form) {
        return LikeDTO.fromEntity(repo.save(form.toEntity()));
    }

    @Override
    public LikeDTO update(Long id, LikeForm form) {
        Like existingLike = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Like with id " + id + " doesn't exist."));

        Like updatedLike = form.toEntity();
        existingLike.setUser(updatedLike.getUser());
        existingLike.setPost(updatedLike.getPost());

        return LikeDTO.fromEntity(repo.save(existingLike));
    }

    @Override
    public LikeDTO delete(Long id) {
        Like existingLike = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Like with id " + id + " doesn't exist."));
        repo.delete(existingLike);
        return LikeDTO.fromEntity(existingLike);
    }
}
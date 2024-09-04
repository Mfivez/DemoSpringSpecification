package com.example.demo.bll.services;

import com.example.demo.bll.models.dtos.LikeDTO;
import com.example.demo.bll.models.forms.LikeForm;

import java.util.List;

public interface LikeService {

    LikeDTO getOne(Long id);

    List<LikeDTO> getAll();

    LikeDTO addOne(LikeForm entity);

    LikeDTO update(Long id, LikeForm entity);

    LikeDTO delete(Long id);
}

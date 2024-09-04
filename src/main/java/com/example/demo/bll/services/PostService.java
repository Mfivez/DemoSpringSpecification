package com.example.demo.bll.services;

import com.example.demo.bll.models.dtos.PostDTO;
import com.example.demo.bll.models.forms.PostForm;

import java.util.List;

public interface PostService {

    PostDTO getOne(Long id);

    List<PostDTO> getAll();

    PostDTO addOne(PostForm entity);

    PostDTO update(Long id, PostForm entity);

    PostDTO delete(Long id);
}

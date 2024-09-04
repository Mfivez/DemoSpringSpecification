package com.example.demo.bll.services;

import com.example.demo.bll.models.dtos.CommentDTO;
import com.example.demo.bll.models.forms.CommentForm;
import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.List;

public interface CommentService {

    CommentDTO getOne(Long id);

    List<CommentDTO> getAll();

    CommentDTO addOne(CommentForm entity);

    CommentDTO update(Long id, CommentForm form);

    CommentDTO delete(Long id);
}

package com.example.demo.bll.services;

import com.example.demo.bll.models.dtos.UserDTO;
import com.example.demo.bll.models.forms.UserForm;
import com.example.demo.domain.entities.User;

import java.util.List;

public interface UserService {

    UserDTO getOne(Long id);

    List<UserDTO> getAll();

    UserDTO addOne(UserForm form);

    UserDTO update(Long id, UserForm entity);

    UserDTO delete(Long id);

    List<UserDTO> findByUsername(String username);

    List<UserDTO> findByFirstname(String firstname);

    List<UserDTO> findByLastname(String lastname);

    List<UserDTO> findByEmail(String email);

    List<UserDTO> findByCriteria(UserForm form);
}

// Interface BaseService {toutes les méthodes de }base service
// Quand vous étendez ceci sur un autre service :
// interface UserService {Toutes les méthodes de Uservices}
// BaseService + UserService

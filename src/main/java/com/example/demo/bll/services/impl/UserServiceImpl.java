package com.example.demo.bll.services.impl;
import com.example.demo.bll.models.dtos.UserDTO;
import com.example.demo.bll.models.forms.UserForm;
import com.example.demo.bll.services.UserService;
import com.example.demo.bll.specifications.UserSpecification;
import com.example.demo.dal.repositories.UserRepository;
import com.example.demo.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    public UserDTO getOne(Long id) {
        User user = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Post with id " + id + " doesn't exist."));
        return UserDTO.fromEntity(user);
    }

    @Override
    public List<UserDTO> getAll() {
        return repo.findAll().stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO addOne(UserForm form) {
        return UserDTO.fromEntity(repo.save(form.toEntity()));
    }

    @Override
    public UserDTO update(Long id, UserForm form) {
        User user = repo.findById(id).orElseThrow(() ->
                new RuntimeException("User with id " + id + " doesn't exist."));
        user.setPassword(form.getPassword());
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setLastname(user.getLastname());

        return UserDTO.fromEntity(repo.save(user));
    }

    @Override
    public UserDTO delete(Long id) {
        User existingUser = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Post with id " + id + " doesn't exist."));
        repo.delete(existingUser);
        return UserDTO.fromEntity(existingUser);
    }

    @Override
    public List<UserDTO> findByUsername(String username) {
        System.out.println(repo.findByUsername(username));
        return repo.findByUsername(username).stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByFirstname(String firstname) {
        return repo.findByFirstname(firstname).stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByLastname(String lastname) {
        return repo.findByLastname(lastname).stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByEmail(String email) {
        return repo.findByEmail(email).stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public List<UserDTO> findByCriteria(UserForm form) {

        Specification<User> spec = Specification.where(null);

        if (form.getUsername() != null && !form.getUsername().isEmpty()) {
            spec = spec.and(UserSpecification.hasUsername(form.getUsername()));
        }

        if (form.getEmail() != null && !form.getEmail().isEmpty()) {
            spec = spec.and(UserSpecification.hasEmail(form.getEmail()));
        }

        List<User> users = repo.findAll(spec);
        return users.stream().map(UserDTO::fromEntity).collect(Collectors.toList());
    }
}

package com.example.demo.bll.services.impl;

import com.example.demo.bll.models.dtos.FriendShipDTO;
import com.example.demo.bll.models.forms.FriendShipForm;
import com.example.demo.bll.services.FriendShipService;
import com.example.demo.dal.repositories.FriendShipRepository;
import com.example.demo.domain.entities.FriendShip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendShipServiceImpl implements FriendShipService {

    private final FriendShipRepository repo;

    @Override
    public FriendShipDTO getOne(Long id) {
        FriendShip friendShip = repo.findById(id).orElseThrow(() ->
                new RuntimeException("FriendShip with id " + id + " doesn't exist."));
        return FriendShipDTO.fromEntity(friendShip);
    }

    @Override
    public List<FriendShipDTO> getAll() {
        return repo.findAll().stream()
                .map(FriendShipDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FriendShipDTO addOne(FriendShipForm form) {
        return FriendShipDTO.fromEntity(repo.save(form.toEntity()));
    }

    @Override
    public FriendShipDTO update(Long id, FriendShipForm form) {
        FriendShip friendShip = repo.findById(id).orElseThrow(() ->
                new RuntimeException("FriendShip with id " + id + " doesn't exist."));

        FriendShip updatedfriendShip = form.toEntity();
        friendShip.setUser(updatedfriendShip.getUser());
        friendShip.setFriend(updatedfriendShip.getFriend());

        return FriendShipDTO.fromEntity(repo.save(friendShip));
    }

    @Override
    public FriendShipDTO delete(Long id) {
        FriendShip existingFriendShip = repo.findById(id).orElseThrow(() ->
                new RuntimeException("FriendShip with id " + id + " doesn't exist."));
        repo.delete(existingFriendShip);
        return FriendShipDTO.fromEntity(existingFriendShip);
    }
}
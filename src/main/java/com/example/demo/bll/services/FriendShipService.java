package com.example.demo.bll.services;

import com.example.demo.bll.models.dtos.FriendShipDTO;
import com.example.demo.bll.models.forms.FriendShipForm;

import java.util.List;

public interface FriendShipService {

    FriendShipDTO getOne(Long id);

    List<FriendShipDTO> getAll();

    FriendShipDTO addOne(FriendShipForm entity);

    FriendShipDTO update(Long id, FriendShipForm entity);

    FriendShipDTO delete(Long id);

}

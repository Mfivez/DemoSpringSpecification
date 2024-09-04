package com.example.demo.bll.models.forms;

import com.example.demo.dal.repositories.UserRepository;
import com.example.demo.domain.entities.FriendShip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FriendShipForm {
    private Long userId;
    private Long friendId;

    private final UserRepository userRepo;

    public FriendShip toEntity() {
        FriendShip friendShip = new FriendShip();
        friendShip.setUser(userRepo.findById(userId).orElseThrow());
        friendShip.setFriend(userRepo.findById(friendId).orElseThrow());
        return friendShip;
    }

}
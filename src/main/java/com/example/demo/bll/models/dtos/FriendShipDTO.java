package com.example.demo.bll.models.dtos;

import com.example.demo.domain.entities.FriendShip;

import java.time.LocalDateTime;

public record FriendShipDTO (
    Long userId,
    Long friendId,
    LocalDateTime startDate
) {
    public static FriendShipDTO fromEntity(FriendShip friendship) {
        return new FriendShipDTO(
                friendship.getUser().getId(),
                friendship.getFriend().getId(),
                friendship.getStartDate()
        );
    }
}

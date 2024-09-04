package com.example.demo.dal.repositories;

import com.example.demo.domain.entities.FriendShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendShipRepository extends JpaRepository<FriendShip, Long> {
}

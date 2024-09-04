package com.example.demo.dal.repositories;

import com.example.demo.domain.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}

package com.example.demo.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "friendship")
public class FriendShip extends BaseEntity<Long>{

    @Column(name="start_date")
    private LocalDateTime startDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private User friend;


}

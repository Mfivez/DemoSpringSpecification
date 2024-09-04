package com.example.demo.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
@Getter
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false,updatable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

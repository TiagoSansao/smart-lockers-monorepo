package com.smartlockers.logManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "log")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String event;

    @Column(nullable = false)
    private LocalDateTime dateCreated;

    @Column(nullable = false)
    private Long lockerShelfId;

    @Column(nullable = true)
    private Long actorId;

    @PrePersist
    void setDateCreated() {
        if (dateCreated == null) {
            dateCreated = LocalDateTime.now();
        }
    }
}

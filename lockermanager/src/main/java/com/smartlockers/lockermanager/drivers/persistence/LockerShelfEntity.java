package com.smartlockers.lockermanager.drivers.persistence;

import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.model.LockerShelfSize;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locker_shelf")
@Getter
@Setter
@NoArgsConstructor
public class LockerShelfEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private LockerEntity locker;

    @Column()
    private Boolean isLocked;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private LockerShelfSize size;
}
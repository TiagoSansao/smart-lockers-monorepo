package com.smartlockers.lockermanager.drivers.persistence;

import com.smartlockers.lockermanager.domain.model.LockerShelf;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locker")
@Getter
@Setter
@NoArgsConstructor
public class LockerEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column()
    private Long condominiumId;

    @Column(nullable = false)
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LockerShelfEntity> lockerShelfList = new ArrayList<>();

    public void addLockerShelf(LockerShelfEntity lockerShelfEntity) {
        this.lockerShelfList.add(lockerShelfEntity);
        lockerShelfEntity.setLocker(this);
    }
}
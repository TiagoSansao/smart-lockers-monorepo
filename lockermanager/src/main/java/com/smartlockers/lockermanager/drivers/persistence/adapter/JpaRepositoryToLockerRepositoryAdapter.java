package com.smartlockers.lockermanager.drivers.persistence.adapter;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;

import com.smartlockers.lockermanager.drivers.persistence.adaptee.JpaLockerRepository;
import com.smartlockers.lockermanager.drivers.persistence.LockerEntity;
import com.smartlockers.lockermanager.drivers.persistence.LockerShelfEntity;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class JpaRepositoryToLockerRepositoryAdapter implements LockerRepository {

    JpaLockerRepository jpaLockerRepository;

    @Override
    public Long save(Locker locker) {
        LockerEntity lockerEntity = new LockerEntity();
        lockerEntity.setLocation(locker.location());
        lockerEntity.setCondominiumId(locker.condominiumId());

        for (LockerShelf lockerShelf : locker.lockerShelfList()) {
            LockerShelfEntity lockerShelfEntity = new LockerShelfEntity();
            lockerShelfEntity.setSize(lockerShelf.getSize());
            lockerShelfEntity.setIsLocked(lockerShelf.isLocked());
            lockerShelfEntity.setLocker(lockerEntity);

            lockerEntity.addLockerShelf(lockerShelfEntity);
        }

        return lockerEntity.getId();
    }

    @Override
    public List<Locker> listLocker() {
        List<LockerEntity> lockerEntityList = (List<LockerEntity>) jpaLockerRepository.findAll();

        return lockerEntityList.stream().map((LockerEntity lockerEntity) -> {
           return new Locker(
               lockerEntity.getId(),
               lockerEntity.getCondominiumId(),
               lockerEntity.getLocation(),
               lockerEntity.getLockerShelfList().stream().map((LockerShelfEntity LockerShelfEntity) -> {
                   return new LockerShelf(LockerShelfEntity.getId(), LockerShelfEntity.getIsLocked(), LockerShelfEntity.getSize());
               }).toList()
           );
        }).toList();
    }
}

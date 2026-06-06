package com.smartlockers.lockermanager.drivers.persistence;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.Lock;

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

            lockerEntity.lockerShelfList.add(lockerShelfEntity);
        }

        lockerEntity = jpaLockerRepository.save(lockerEntity);

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
                   return LockerShelf.buildForVisualization(LockerShelfEntity.getId(), LockerShelfEntity.getIsLocked(), LockerShelfEntity.getSize());
               }).toList()
           );
        }).toList();
    }
}

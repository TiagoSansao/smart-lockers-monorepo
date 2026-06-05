package com.smartlockers.lockermanager.drivers.persistence;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;

import lombok.AllArgsConstructor;

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
        }

        lockerEntity = jpaLockerRepository.save(lockerEntity);

        return lockerEntity.getId();
    }
}

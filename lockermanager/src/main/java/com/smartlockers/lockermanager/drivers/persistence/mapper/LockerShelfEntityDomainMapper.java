package com.smartlockers.lockermanager.drivers.persistence.mapper;

import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.drivers.persistence.LockerShelfEntity;

abstract public class LockerShelfEntityDomainMapper {

    public static LockerShelf convert(LockerShelfEntity lockerShelfEntity) {
        LockerShelf domainLockerShelf = new LockerShelf();
        domainLockerShelf.setId(lockerShelfEntity.getId());
        domainLockerShelf.setLocked(lockerShelfEntity.getIsLocked());
        domainLockerShelf.setSize(lockerShelfEntity.getSize());

        return domainLockerShelf;
    }

    public static LockerShelfEntity convert(LockerShelf domainLockerShelf) {
        LockerShelfEntity lockerShelfEntity = new LockerShelfEntity();
        lockerShelfEntity.setId(domainLockerShelf.getId());
        lockerShelfEntity.setIsLocked(domainLockerShelf.isLocked());
        lockerShelfEntity.setSize(domainLockerShelf.getSize());

        return lockerShelfEntity;
    }
}

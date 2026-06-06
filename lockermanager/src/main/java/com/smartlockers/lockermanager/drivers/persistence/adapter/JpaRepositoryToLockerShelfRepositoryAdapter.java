package com.smartlockers.lockermanager.drivers.persistence.adapter;

import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.model.LockerShelfSize;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerShelfRepository;
import com.smartlockers.lockermanager.drivers.persistence.LockerShelfEntity;
import com.smartlockers.lockermanager.drivers.persistence.adaptee.JpaLockerShelfRepository;
import com.smartlockers.lockermanager.drivers.persistence.mapper.LockerShelfEntityDomainMapper;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class JpaRepositoryToLockerShelfRepositoryAdapter implements LockerShelfRepository {

    JpaLockerShelfRepository jpaLockerShelfRepository;

    @Override
    public Optional<LockerShelf> findAvailableLockerShelf(Long lockerId, LockerShelfSize size) {
        LockerShelfEntity lockerShelfEntity = jpaLockerShelfRepository.findFirstByLockerIdAndSizeAndIsLocked(lockerId, size, false);
        if (lockerShelfEntity == null) return Optional.empty();

        LockerShelf domainLockerShelf = LockerShelfEntityDomainMapper.convert(lockerShelfEntity);

        return Optional.of(domainLockerShelf);
    }

    @Override
    public Optional<LockerShelf> findById(Long lockerShelfId) {
        LockerShelfEntity lockerShelfEntity = jpaLockerShelfRepository.findById(lockerShelfId).orElse(null);
        if (lockerShelfEntity == null) return Optional.empty();

        LockerShelf domainLockerShelf = LockerShelfEntityDomainMapper.convert(lockerShelfEntity);

        return Optional.of(domainLockerShelf);
    }

    @Override
    public void update(LockerShelf domainLockerShelf) {
        LockerShelfEntity lockerShelfEntity = jpaLockerShelfRepository.findById(domainLockerShelf.getId()).get();
        lockerShelfEntity.setId(domainLockerShelf.getId());
        lockerShelfEntity.setIsLocked(domainLockerShelf.isLocked());
        lockerShelfEntity.setSize(domainLockerShelf.getSize());

        jpaLockerShelfRepository.save(lockerShelfEntity);
    }
}

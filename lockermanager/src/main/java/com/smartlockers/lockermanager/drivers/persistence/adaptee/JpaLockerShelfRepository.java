package com.smartlockers.lockermanager.drivers.persistence.adaptee;

import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.model.LockerShelfSize;
import com.smartlockers.lockermanager.drivers.persistence.LockerShelfEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLockerShelfRepository extends CrudRepository<LockerShelfEntity, Long> {
    LockerShelfEntity findFirstByLockerIdAndSizeAndIsLocked(Long lockerId, LockerShelfSize size, Boolean isLocked);
}

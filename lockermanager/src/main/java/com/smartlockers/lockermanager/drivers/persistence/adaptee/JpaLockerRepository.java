package com.smartlockers.lockermanager.drivers.persistence.adaptee;

import com.smartlockers.lockermanager.drivers.persistence.LockerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLockerRepository extends CrudRepository<LockerEntity, Long> { }

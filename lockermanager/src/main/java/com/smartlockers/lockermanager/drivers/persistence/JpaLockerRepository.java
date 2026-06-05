package com.smartlockers.lockermanager.drivers.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLockerRepository extends CrudRepository<LockerEntity, Long> { }

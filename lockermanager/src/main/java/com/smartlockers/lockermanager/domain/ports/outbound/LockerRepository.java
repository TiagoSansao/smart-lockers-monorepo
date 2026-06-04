package com.smartlockers.lockermanager.domain.ports.outbound;

import com.smartlockers.lockermanager.domain.model.Locker;

public interface LockerRepository {
    public Locker findByNameAndCondominiumId(String name, Long condominiumId);

    public Long save(Locker locker);
}
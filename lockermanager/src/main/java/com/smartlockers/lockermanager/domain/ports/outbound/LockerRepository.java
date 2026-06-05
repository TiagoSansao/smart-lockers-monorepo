package com.smartlockers.lockermanager.domain.ports.outbound;

import com.smartlockers.lockermanager.domain.model.Locker;

public interface LockerRepository {
    public Long save(Locker locker);
}
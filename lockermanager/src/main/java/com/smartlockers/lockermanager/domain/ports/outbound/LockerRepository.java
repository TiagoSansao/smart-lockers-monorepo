package com.smartlockers.lockermanager.domain.ports.outbound;

import com.smartlockers.lockermanager.domain.model.Locker;

import java.util.List;

public interface LockerRepository {
    public Long save(Locker locker);

    public List<Locker> listLocker();
}
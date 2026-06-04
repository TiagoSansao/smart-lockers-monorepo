package com.smartlockers.lockermanager.domain.ports.inbound;

import com.smartlockers.lockermanager.domain.model.Locker;

public interface CreateLockerUseCase {
    public Long createLocker(Locker locker);
}
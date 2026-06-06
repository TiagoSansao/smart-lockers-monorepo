package com.smartlockers.lockermanager.domain.ports.inbound;

import com.smartlockers.lockermanager.domain.model.Locker;

import java.util.List;

public interface ListLockersUseCase {
    public List<Locker> listLockers();
}
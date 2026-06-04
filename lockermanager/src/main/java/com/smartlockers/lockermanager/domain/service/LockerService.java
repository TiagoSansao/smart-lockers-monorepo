package com.smartlockers.lockermanager.domain.service;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.ports.inbound.CreateLockerUseCase;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;

public class LockerService implements CreateLockerUseCase {

    private static LockerRepository lockerRepository;

    @Override
    public Long createLocker(Locker locker) {
        Long lockerId = lockerRepository.save(locker);

        return lockerId;
    }
}

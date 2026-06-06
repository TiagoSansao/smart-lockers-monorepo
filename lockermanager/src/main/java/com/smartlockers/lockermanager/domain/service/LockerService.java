package com.smartlockers.lockermanager.domain.service;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.ports.inbound.CreateLockerUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ListLockersUseCase;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LockerService implements CreateLockerUseCase, ListLockersUseCase {

    private final LockerRepository lockerRepository;

    @Override
    public Long createLocker(Locker locker) {
        Long lockerId = lockerRepository.save(locker);

        return lockerId;
    }

    public List<Locker> listLockers() {
        return lockerRepository.listLocker();
    }
}

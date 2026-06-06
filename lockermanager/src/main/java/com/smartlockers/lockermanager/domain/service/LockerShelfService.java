package com.smartlockers.lockermanager.domain.service;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.model.LockerShelfSize;
import com.smartlockers.lockermanager.domain.ports.inbound.CreateLockerUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ListLockersUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ReserveLockerShelfUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.UnlockLockerShelfUseCase;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;

import com.smartlockers.lockermanager.domain.ports.outbound.LockerShelfRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LockerShelfService implements ReserveLockerShelfUseCase, UnlockLockerShelfUseCase {

    private final LockerShelfRepository lockerShelfRepository;

    @Override
    public Long reserveAnyAvailableLockerShelf(Long lockerId, LockerShelfSize lockerShelfSize) {
       LockerShelf availableLockerShelf = lockerShelfRepository.findAvailableLockerShelf(lockerId, lockerShelfSize);
       availableLockerShelf.setLocked(true);

       lockerShelfRepository.update(availableLockerShelf);

       return availableLockerShelf.getId();
    }

    @Override
    public void unlockLockerShelf(Long lockerShelfId) {
        LockerShelf lockerShelf = lockerShelfRepository.findById(lockerShelfId);
        lockerShelf.setLocked(false);

        lockerShelfRepository.update(lockerShelf);
    }
}

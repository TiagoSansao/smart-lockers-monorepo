package com.smartlockers.lockermanager.domain.ports.inbound;

import com.smartlockers.lockermanager.domain.model.LockerShelfSize;

public interface ReserveLockerShelfUseCase {
    public Long reserveAnyAvailableLockerShelf(Long lockerId, LockerShelfSize lockerShelfSize);
}
package com.smartlockers.lockermanager.domain.ports.inbound;

import com.smartlockers.lockermanager.domain.model.LockerShelfSize;

public interface UnlockLockerShelfUseCase {
    public void unlockLockerShelf(Long lockerShelfId);
}
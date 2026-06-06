package com.smartlockers.lockermanager.domain.ports.outbound;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.model.LockerShelfSize;

import java.util.List;

public interface LockerShelfRepository {
    public LockerShelf findAvailableLockerShelf(Long lockerId, LockerShelfSize size);

    public LockerShelf findById(Long lockerShelfId);

    public void update(LockerShelf lockerShelf);
}
package com.smartlockers.lockermanager.domain.ports.outbound;

import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.model.LockerShelfSize;

import java.util.Optional;

public interface LockerShelfRepository {
    public Optional<LockerShelf> findAvailableLockerShelf(Long lockerId, LockerShelfSize size);

    public Optional<LockerShelf> findById(Long lockerShelfId);

    public void update(LockerShelf lockerShelf);
}
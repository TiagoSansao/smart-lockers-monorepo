package com.smartlockers.lockermanager.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LockerShelf {

    private Long id;

    private boolean isLocked;

    private LockerShelfSize size;

    public static LockerShelf buildForCreation(LockerShelfSize size) {
        LockerShelf lockerShelf = new LockerShelf();
        lockerShelf.isLocked = false;
        lockerShelf.size = size;

        return lockerShelf;
    }

    public static LockerShelf buildForVisualization(Long id, boolean isLocked, LockerShelfSize size) {
        LockerShelf lockerShelf = new LockerShelf();
        lockerShelf.id = id;
        lockerShelf.isLocked = isLocked;
        lockerShelf.size = size;

        return lockerShelf;
    }
}
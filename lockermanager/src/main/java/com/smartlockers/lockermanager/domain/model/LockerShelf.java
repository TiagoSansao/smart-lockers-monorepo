package com.smartlockers.lockermanager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
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
}
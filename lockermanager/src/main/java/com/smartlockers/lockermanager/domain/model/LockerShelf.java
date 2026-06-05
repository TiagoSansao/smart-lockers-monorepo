package com.smartlockers.lockermanager.domain.model;

import lombok.Getter;

@Getter
public class LockerShelf {

    public boolean isLocked;

    public LockerShelfSize size;

    public LockerShelf(LockerShelfSize size) {
        this.isLocked = false;
        this.size = size;
    }
}
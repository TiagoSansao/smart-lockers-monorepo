package com.smartlockers.lockermanager.domain.model;

public record LockerShelf(
    boolean isLocked,
    LockerShelfSize size
) {}
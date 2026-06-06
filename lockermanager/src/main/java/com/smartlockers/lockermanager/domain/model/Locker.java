package com.smartlockers.lockermanager.domain.model;

import java.util.List;

public record Locker(
    Long id,
    Long condominiumId,
    String location,
    List<LockerShelf> lockerShelfList
) { }

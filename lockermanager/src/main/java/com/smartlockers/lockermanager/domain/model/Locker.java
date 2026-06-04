package com.smartlockers.lockermanager.domain.model;

public record Locker(
  Long condominiumId,
  String location,
  LockerShelf lockerShelf
) { }

package com.smartlockers.lockermanager.drivers.web.dto;

import com.smartlockers.lockermanager.domain.model.LockerShelfSize;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReserveLockerShelfDTO {

    @NotNull
    LockerShelfSize size;
}

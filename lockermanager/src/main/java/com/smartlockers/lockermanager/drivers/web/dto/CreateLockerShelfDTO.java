package com.smartlockers.lockermanager.drivers.web.dto;

import com.smartlockers.lockermanager.domain.model.LockerShelfSize;
import jakarta.validation.constraints.NotNull;

public class CreateLockerShelfDTO {

    @NotNull
    LockerShelfSize size;
}

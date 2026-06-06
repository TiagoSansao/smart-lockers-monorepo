package com.smartlockers.lockermanager.drivers.web;

import com.smartlockers.lockermanager.domain.ports.inbound.UnlockLockerShelfUseCase;
import com.smartlockers.lockermanager.drivers.web.dto.ReserveLockerShelfDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/lockerShelf")
@RestController
public class LockerShelfController {

    private final UnlockLockerShelfUseCase unlockLockerShelfUseCase;

    @PostMapping(path = "/{lockerShelfId}/unlock")
    public void unlockLockerShelf(@PathVariable Long lockerShelfId) {
        unlockLockerShelfUseCase.unlockLockerShelf(lockerShelfId);
    }
}

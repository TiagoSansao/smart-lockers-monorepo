package com.smartlockers.lockermanager.drivers.web;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.ports.inbound.CreateLockerUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ListLockersUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ReserveLockerShelfUseCase;
import com.smartlockers.lockermanager.drivers.web.dto.CreateLockerDTO;
import com.smartlockers.lockermanager.drivers.web.dto.ReserveLockerShelfDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NullMarked
@RequestMapping("/locker")
public class LockerController {

    private final CreateLockerUseCase createLockerUseCase;

    private final ListLockersUseCase listLockersUseCase;

    private final ReserveLockerShelfUseCase reserveLockerShelfUseCase;

    @PostMapping
    public Long createLocker(@Valid @RequestBody CreateLockerDTO createLockerDTO) {

        Locker domainLocker = createLockerDTO.toDomain();
        Long id = createLockerUseCase.createLocker(domainLocker);

        return id;
    }

    @GetMapping
    public List<Locker> listLockers() {
        return listLockersUseCase.listLockers();
    }

    @PostMapping(path = "/{lockerId}/reservation")
    public Long reserveLockerShelf(@PathVariable Long lockerId, @Valid @RequestBody ReserveLockerShelfDTO reserveLockerShelfDTO) {
        return reserveLockerShelfUseCase.reserveAnyAvailableLockerShelf(lockerId, reserveLockerShelfDTO.getSize());
    }
}

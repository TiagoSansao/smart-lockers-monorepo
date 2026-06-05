package com.smartlockers.lockermanager.drivers.web.dto;

import com.smartlockers.lockermanager.domain.model.Locker;
import com.smartlockers.lockermanager.domain.model.LockerShelf;
import com.smartlockers.lockermanager.domain.model.LockerShelfSize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CreateLockerDTO {

    @NotNull
    Long condominiumId;

    @NotBlank
    String location;

    @Valid
    @Size(min = 1)
    @NotNull
    List<LockerShelfSize> lockerShelfSizeList;

    public Locker toDomain() {
        List<LockerShelf> domainLockerShelfList = lockerShelfSizeList.stream().map(LockerShelf::new).toList();
        Locker domainLocker = new Locker(condominiumId, location, domainLockerShelfList);

        return domainLocker;
    }
}

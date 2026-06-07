package com.smartlockers.deliveryManager.integration.dto;

import com.smartlockers.deliveryManager.entity.DeliveryItemSize;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReserveLockerShelfRequestDTO {

    @NotNull
    DeliveryItemSize size;
}

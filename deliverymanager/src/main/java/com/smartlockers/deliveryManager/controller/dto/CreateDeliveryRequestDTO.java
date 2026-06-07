package com.smartlockers.deliveryManager.controller.dto;

import com.smartlockers.deliveryManager.entity.DeliveryItemSize;
import jakarta.validation.constraints.NotNull;

public record CreateDeliveryRequestDTO(

        @NotNull
        Long lockerId,

        @NotNull
        Long residentId,

        @NotNull
        DeliveryItemSize itemSize
) {
}

package com.smartlockers.deliveryManager.controller.dto;

public record DeliveryResponseDTO(
        Long id,
        Long lockerShelfId,
        Long residentId,
        Boolean retrieved
) {
}

package com.smartlockers.deliveryManager.integration.dto;

public record ApiErrorResponseDTO(
        String code,
        String message
) {
}

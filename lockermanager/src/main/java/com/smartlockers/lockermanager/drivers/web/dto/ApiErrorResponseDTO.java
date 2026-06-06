package com.smartlockers.lockermanager.drivers.web.dto;

public record ApiErrorResponseDTO(
        String code,
        String message
) {
}

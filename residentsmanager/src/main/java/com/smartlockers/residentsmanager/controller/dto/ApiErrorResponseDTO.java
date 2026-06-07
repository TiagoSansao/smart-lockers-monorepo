package com.smartlockers.residentsmanager.controller.dto;

public record ApiErrorResponseDTO(
        String code,
        String message
) {
}

package com.smartlockers.logManager.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CreateLogRequestDTO(
        @NotNull(message = "event cannot be null")
        String event,
        @NotNull(message = "lockerShelfId cannot be null")
        Long lockerShelfId,
        Long actorId
) {
}

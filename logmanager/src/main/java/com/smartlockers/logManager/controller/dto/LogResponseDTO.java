package com.smartlockers.logManager.controller.dto;

import java.time.LocalDateTime;

public record LogResponseDTO(
        Long id,
        String event,
        LocalDateTime dateCreated,
        Long lockerShelfId,
        Long actorId
) {
}

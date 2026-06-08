package com.smartlockers.logManager.controller;

import com.smartlockers.logManager.controller.dto.CreateLogRequestDTO;
import com.smartlockers.logManager.controller.dto.LogResponseDTO;
import com.smartlockers.logManager.mapper.LogMapper;
import com.smartlockers.logManager.service.LogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NullMarked
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/log")
public class LogController {

    private final LogService logService;

    private final LogMapper logMapper;

    @GetMapping()
    public List<LogResponseDTO> list() {
        return logMapper.toResponseList(logService.list());
    }

    @PostMapping()
    public Long create(@Valid @RequestBody CreateLogRequestDTO createLogRequestDTO) {
        return logService.save(createLogRequestDTO.event(), createLogRequestDTO.lockerShelfId(), createLogRequestDTO.actorId());
    }
}

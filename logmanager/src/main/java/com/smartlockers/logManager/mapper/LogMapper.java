package com.smartlockers.logManager.mapper;

import com.smartlockers.logManager.controller.dto.LogResponseDTO;
import com.smartlockers.logManager.entity.Log;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogMapper {
    LogResponseDTO toResponse(Log log);

    List<LogResponseDTO> toResponseList(List<Log> logs);
}

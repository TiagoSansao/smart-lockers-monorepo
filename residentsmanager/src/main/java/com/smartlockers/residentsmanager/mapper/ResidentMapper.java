package com.smartlockers.residentsmanager.mapper;

import com.smartlockers.residentsmanager.controller.dto.ResidentResponseListDTO;
import com.smartlockers.residentsmanager.entity.Resident;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResidentMapper {
    List<ResidentResponseListDTO> toResponseList(List<Resident> residentList);
}

package com.smartlockers.residentsmanager.controller;

import com.smartlockers.residentsmanager.controller.dto.CreateResidentRequestDTO;
import com.smartlockers.residentsmanager.controller.dto.ResidentResponseListDTO;
import com.smartlockers.residentsmanager.mapper.ResidentMapper;
import com.smartlockers.residentsmanager.service.ResidentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NullMarked
@AllArgsConstructor
@RestController
@RequestMapping(path = "/resident")
public class ResidentController {

    private final ResidentService residentService;

    private final ResidentMapper residentMapper;

    @PostMapping()
    public Long create(@Valid @RequestBody CreateResidentRequestDTO createResidentRequestDTO) {
        return residentService.save(createResidentRequestDTO.condominiumId(), createResidentRequestDTO.name());
    }

    @GetMapping()
    public List<ResidentResponseListDTO> list() {
        return residentMapper.toResponseList(residentService.list());
    }
}

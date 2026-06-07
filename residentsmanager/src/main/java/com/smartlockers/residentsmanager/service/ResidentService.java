package com.smartlockers.residentsmanager.service;

import com.smartlockers.residentsmanager.entity.Resident;
import com.smartlockers.residentsmanager.exception.AlreadyExistentResidentInCondominiumException;
import com.smartlockers.residentsmanager.persistence.ResidentRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NullMarked
@AllArgsConstructor
public class ResidentService {

    private final ResidentRepository residentRepository;

    public Long save(Long condominiumId, String name) {
        boolean alreadyExistent = residentRepository.existsByCondominiumIdAndName(condominiumId, name);
        if (alreadyExistent) throw new AlreadyExistentResidentInCondominiumException("Já existe um condômino cadastrado com este nome neste condomínio.");

        Resident resident = new Resident();
        resident.setCondominiumId(condominiumId);
        resident.setName(name);

        residentRepository.save(resident);

        return resident.getId();
    }

    public List<Resident> list() {
        return residentRepository.findAll();
    }
}

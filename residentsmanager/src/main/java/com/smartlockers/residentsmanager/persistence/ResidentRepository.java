package com.smartlockers.residentsmanager.persistence;

import com.smartlockers.residentsmanager.entity.Resident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Boolean existsByCondominiumIdAndName(Long condominiumId, String name);
}

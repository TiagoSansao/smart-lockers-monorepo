package com.smartlockers.residentsmanager.controller.dto;

public record ResidentResponseListDTO(
    Long id,
    Long condominiumId,
    String name
) { }

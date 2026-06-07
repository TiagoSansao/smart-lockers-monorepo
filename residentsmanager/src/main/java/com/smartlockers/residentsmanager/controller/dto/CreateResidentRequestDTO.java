package com.smartlockers.residentsmanager.controller.dto;

public record CreateResidentRequestDTO(
    Long condominiumId,
    String name
) { }

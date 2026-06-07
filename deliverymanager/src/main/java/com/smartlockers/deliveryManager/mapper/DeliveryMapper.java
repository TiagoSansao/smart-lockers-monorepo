package com.smartlockers.deliveryManager.mapper;

import com.smartlockers.deliveryManager.controller.dto.DeliveryResponseDTO;
import com.smartlockers.deliveryManager.entity.Delivery;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryResponseDTO toResponse(Delivery delivery);

    List<DeliveryResponseDTO> toResponseList(List<Delivery> deliveries);
}

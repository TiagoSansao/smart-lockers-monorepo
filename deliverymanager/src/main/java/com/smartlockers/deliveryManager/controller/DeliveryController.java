package com.smartlockers.deliveryManager.controller;

import com.smartlockers.deliveryManager.controller.dto.CreateDeliveryRequestDTO;
import com.smartlockers.deliveryManager.controller.dto.DeliveryResponseDTO;
import com.smartlockers.deliveryManager.entity.Delivery;
import com.smartlockers.deliveryManager.mapper.DeliveryMapper;
import com.smartlockers.deliveryManager.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NullMarked
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    private final DeliveryMapper deliveryMapper;

    @GetMapping()
    public List<DeliveryResponseDTO> list(@RequestParam(required = false) Long residentId, @RequestParam(required = false) Boolean retrieved) {
        return deliveryMapper.toResponseList(deliveryService.list(residentId, retrieved));
    }

    @PostMapping("/{lockerShelfId}/pickup")
    public void pickup(@PathVariable Long lockerShelfId) {
        deliveryService.pickup(lockerShelfId);
    }

    @PostMapping()
    public Long create(@Valid @RequestBody CreateDeliveryRequestDTO createDeliveryRequestDTO) {
        return deliveryService.save(createDeliveryRequestDTO.residentId(), createDeliveryRequestDTO.lockerId(), createDeliveryRequestDTO.itemSize());
    }
}

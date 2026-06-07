package com.smartlockers.deliveryManager.service;

import com.smartlockers.deliveryManager.entity.Delivery;
import com.smartlockers.deliveryManager.entity.DeliveryItemSize;
import com.smartlockers.deliveryManager.integration.LockerManagerClient;
import com.smartlockers.deliveryManager.persistence.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NullMarked
@AllArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    private final LockerManagerClient lockerManagerClient;

    public Long save(Long residentId, Long lockerId, DeliveryItemSize deliveryItemSize) {
        Long reservedLockerShelfId = lockerManagerClient.getAvailableLockerShelf(lockerId, deliveryItemSize);

        Delivery delivery = new Delivery();
        delivery.setLockerShelfId(reservedLockerShelfId);
        delivery.setResidentId(residentId);
        delivery.setRetrieved(false);

        deliveryRepository.save(delivery);

        return delivery.getId();
    }

    public void pickup(Long id) {
    }
}

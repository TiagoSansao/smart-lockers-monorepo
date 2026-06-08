package com.smartlockers.deliveryManager.service;

import com.smartlockers.deliveryManager.entity.Delivery;
import com.smartlockers.deliveryManager.entity.DeliveryItemSize;
import com.smartlockers.deliveryManager.exception.BusinessException;
import com.smartlockers.deliveryManager.integration.LockerManagerClient;
import com.smartlockers.deliveryManager.integration.LogManagerClient;
import com.smartlockers.deliveryManager.persistence.DeliveryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NullMarked
@AllArgsConstructor
@Transactional
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;


    private final LogManagerClient logManagerClient;
    private final LockerManagerClient lockerManagerClient;

    public List<Delivery> list(@Nullable Long residentId, @Nullable Boolean retrieved) {
        return deliveryRepository.findByResidentIdAndRetrieved(residentId, retrieved);
    }

    public Long save(Long residentId, Long lockerId, DeliveryItemSize deliveryItemSize) {
        Long reservedLockerShelfId = lockerManagerClient.getAvailableLockerShelf(lockerId, deliveryItemSize);

        Delivery delivery = new Delivery();
        delivery.setLockerShelfId(reservedLockerShelfId);
        delivery.setResidentId(residentId);
        delivery.setRetrieved(false);

        deliveryRepository.save(delivery);

        logManagerClient.registerLog("place_item", reservedLockerShelfId, null);

        return delivery.getId();
    }

    public void pickup(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new BusinessException("Delivery não encontrado."));
        delivery.setRetrieved(true);

        deliveryRepository.save(delivery);

        logManagerClient.registerLog("retrieve_item", delivery.getLockerShelfId(), delivery.getResidentId());

        lockerManagerClient.unlockLockerShelf(delivery.getLockerShelfId());
    }
}

package com.smartlockers.deliveryManager.persistence;

import com.smartlockers.deliveryManager.entity.Delivery;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@NullMarked
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    @Query("SELECT d FROM Delivery d WHERE " +
            "(:residentId IS NULL OR d.residentId = :residentId) AND " +
            "(:retrieved IS NULL OR d.retrieved = :retrieved)")
    List<Delivery> findByResidentIdAndRetrieved(
            @Param("residentId") Long residentId,
            @Param("retrieved") Boolean retrieved
    );
}

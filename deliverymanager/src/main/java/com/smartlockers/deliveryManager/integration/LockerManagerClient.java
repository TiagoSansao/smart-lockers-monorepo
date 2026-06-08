package com.smartlockers.deliveryManager.integration;

import com.smartlockers.deliveryManager.entity.DeliveryItemSize;
import com.smartlockers.deliveryManager.integration.dto.ApiErrorResponseDTO;
import com.smartlockers.deliveryManager.integration.dto.ReserveLockerShelfRequestDTO;
import com.smartlockers.deliveryManager.exception.BusinessException;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Component
@NullMarked
public class LockerManagerClient {

    private RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(LockerManagerClient.class);

    public LockerManagerClient(@Value("${integration.lockermanager.baseUrl}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    public Long getAvailableLockerShelf(Long lockerId, DeliveryItemSize deliveryItemSize) {
        ReserveLockerShelfRequestDTO reserveLockerShelfRequestDTO = new ReserveLockerShelfRequestDTO(deliveryItemSize);

        String urlPath = "/locker/%s/reservation".formatted(lockerId.toString());
        try {
            Long reservedLockerShelfId = restClient.post().uri(urlPath).body(reserveLockerShelfRequestDTO).retrieve().body(Long.class);

            return reservedLockerShelfId;
        } catch (HttpClientErrorException httpClientErrorException) {
            ApiErrorResponseDTO apiErrorResponseDTO = httpClientErrorException.getResponseBodyAs(ApiErrorResponseDTO.class);
            throw new BusinessException(apiErrorResponseDTO.message());
        } catch (Exception e) {
            logger.error("Unhandled exception while trying to request an available locker shelf from Locker Manager Api.");

            throw new RuntimeException(e);
        }
    }

    public void unlockLockerShelf(Long lockerShelfId) {
        String urlPath = "/lockerShelf/%s/unlock".formatted(lockerShelfId.toString());
        try {
            restClient.post().uri(urlPath).retrieve().toBodilessEntity();
        } catch (HttpClientErrorException httpClientErrorException) {
            ApiErrorResponseDTO apiErrorResponseDTO = httpClientErrorException.getResponseBodyAs(ApiErrorResponseDTO.class);
            throw new BusinessException(apiErrorResponseDTO.message());
        } catch (Exception e) {
            logger.error("Unhandled exception while trying to request an available locker shelf from Locker Manager Api.");

            throw new RuntimeException(e);
        }
    }
}

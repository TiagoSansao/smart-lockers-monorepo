package com.smartlockers.deliveryManager.integration;

import com.smartlockers.deliveryManager.exception.BusinessException;
import com.smartlockers.deliveryManager.integration.dto.ApiErrorResponseDTO;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Component
@NullMarked
public class LockerEmbeddedSystemClient {

    private final RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(LockerEmbeddedSystemClient.class);

    public LockerEmbeddedSystemClient(@Value("${integration.embeddedsystemonlockermanager.baseUrl}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    public void openLockerShelf(Long lockerShelfId) {
        String urlPath = "/lockerShelf/%s/open".formatted(lockerShelfId.toString());
        try {
            restClient.post().uri(urlPath).retrieve().toBodilessEntity();
        } catch (HttpClientErrorException httpClientErrorException) {
            ApiErrorResponseDTO apiErrorResponseDTO = httpClientErrorException.getResponseBodyAs(ApiErrorResponseDTO.class);
            throw new BusinessException(apiErrorResponseDTO.message());
        } catch (Exception e) {
            logger.error("Unhandled exception while trying to open a locker shelf in Locker Embedded System Api.");

            throw new RuntimeException(e);
        }
    }
}
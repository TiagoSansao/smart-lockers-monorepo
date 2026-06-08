package com.smartlockers.deliveryManager.integration;

import com.smartlockers.deliveryManager.exception.BusinessException;
import com.smartlockers.deliveryManager.integration.dto.ApiErrorResponseDTO;
import com.smartlockers.deliveryManager.integration.dto.CreateLogRequestDTO;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Component
@NullMarked
public class LogManagerClient {

    private RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(LogManagerClient.class);

    public LogManagerClient(@Value("${integration.logmanager.baseUrl}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    public void registerLog(String event, Long lockerShelfId, @Nullable Long actorId) {
        CreateLogRequestDTO createLogRequestDTO = new CreateLogRequestDTO(event, lockerShelfId, actorId);

        String urlPath = "/api/v1/log";
        try {
            restClient.post().uri(urlPath).body(createLogRequestDTO).retrieve().toBodilessEntity();
        } catch (HttpClientErrorException httpClientErrorException) {
            ApiErrorResponseDTO apiErrorResponseDTO = httpClientErrorException.getResponseBodyAs(ApiErrorResponseDTO.class);
            throw new BusinessException(apiErrorResponseDTO.message());
        } catch (Exception e) {
            logger.error("Unhandled exception while trying to register a log in Log Manager Api.");

            throw new RuntimeException(e);
        }
    }
}

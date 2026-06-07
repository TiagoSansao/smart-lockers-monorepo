package com.smartlockers.deliveryManager.controller;

import com.smartlockers.residentsmanager.controller.dto.ApiErrorResponseDTO;
import com.smartlockers.residentsmanager.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleBusinessException(BusinessException businessException) {
        ApiErrorResponseDTO apiErrorResponseDTO = new ApiErrorResponseDTO("BUSINESS_EXCEPTION", businessException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponseDTO);
    }
}

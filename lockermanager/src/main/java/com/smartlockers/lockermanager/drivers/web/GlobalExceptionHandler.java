package com.smartlockers.lockermanager.drivers.web;

import com.smartlockers.lockermanager.domain.exception.BusinessException;
import com.smartlockers.lockermanager.drivers.web.dto.ApiErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
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

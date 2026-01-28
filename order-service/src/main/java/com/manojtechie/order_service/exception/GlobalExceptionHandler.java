package com.manojtechie.order_service.exception;


import com.manojtechie.order_service.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(BadRequestException ex) {
    ApiErrorResponse response = new ApiErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
}
}

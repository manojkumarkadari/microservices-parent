package com.manojtechie.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    private int errorCode;
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ApiErrorResponse(int code, String description) {
    }
}

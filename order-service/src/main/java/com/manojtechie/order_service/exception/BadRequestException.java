package com.manojtechie.order_service.exception;

public class BadRequestException extends AbstractExceptionWithDetails {
    public BadRequestException(ErrorCodes errorCodes, String additionalDetails){
        super(errorCodes,additionalDetails);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

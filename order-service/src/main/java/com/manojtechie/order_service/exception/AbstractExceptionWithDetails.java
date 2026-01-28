package com.manojtechie.order_service.exception;

import lombok.Data;


@SuppressWarnings("serial")
public abstract class AbstractExceptionWithDetails extends RuntimeException{
private final ErrorCodes error;
protected final String[] additionalInfo;

public AbstractExceptionWithDetails(ErrorCodes error,String... additionalInfo)
{
this(error,null,additionalInfo);
}
public AbstractExceptionWithDetails(ErrorCodes error,Throwable ex, String... additionalInfo){
    super(ex);
    this.error= error;
    this.additionalInfo= additionalInfo;
}

    public ErrorCodes getError() {
        return error;
    }
    public String[] getAdditionalInfo(){
    return additionalInfo;
    }
    public int getErrorCode(){
    return error.getCode();
    }
    public String getErrorMessage(){
    return error.getDescription();
    }
    public String getMessage(){
    return toString();
    }
    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Error code");
    sb.append(error.getCode());
    sb.append(":");
    sb.append(error.getDescription());
    sb.append("; Additonal info:[");
    for(String addl: additionalInfo){
        sb.append(addl + ",");
    }
    sb.append("]");
    return sb.toString();
    }
}

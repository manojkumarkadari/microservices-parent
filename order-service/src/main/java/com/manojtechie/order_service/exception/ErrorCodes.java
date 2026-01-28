package com.manojtechie.order_service.exception;

public enum ErrorCodes {

    OK("OK",0),
    OUT_OF_STOCK("Product is Out of Stock",10001);

    private String description;
    private final int code;
    ErrorCodes(String description,int code){
        this.description= description;
        this.code=code;
    }
    public String getDescription(){
        return description;
    }
    public int getCode(){
        return code;
    }
}

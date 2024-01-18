package com.codeing.gestionstock.exception;

public enum ErrorCodes {
    PRODUIT_NOT_FOUND(1000),
    PRODUIT_NOT_VALID(1001);
    private Integer code;
    ErrorCodes(Integer code){
        this.code = code;
    }
    public Integer getCode(){
        return this.code;
    }
}

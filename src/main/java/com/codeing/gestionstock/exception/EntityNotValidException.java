package com.codeing.gestionstock.exception;

import lombok.Getter;

import java.util.List;

public class EntityNotValidException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;
    @Getter
    private List<String> error;

    public EntityNotValidException(String msg){
        super(msg);
    }
    public EntityNotValidException(String msg,Throwable cause){
        super(msg,cause);
    }
    public EntityNotValidException(String msg,Throwable cause,ErrorCodes errorCodes){
        super(msg,cause);
    }
    public EntityNotValidException(String msg,ErrorCodes errorCodes,List<String> error){
        super(msg);
        this.errorCodes =errorCodes;
        this.error =error;
    }
    public EntityNotValidException(String msg,ErrorCodes errorCodes){
        super(msg);
        this.errorCodes=errorCodes;
    }
    public EntityNotValidException(String msg, List<String> error){
        super(msg);
        this.error=error;
    }
}

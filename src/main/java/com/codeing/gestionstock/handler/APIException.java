package com.codeing.gestionstock.handler;


import com.codeing.gestionstock.exception.EntityNotFoundException;
import com.codeing.gestionstock.exception.EntityNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class APIException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerException(EntityNotFoundException e, WebRequest webRequest){
        final Integer httpStatus=HttpStatus.NOT_FOUND.value();
        final ErrorDto errorDto = ErrorDto.builder()
                .message(e.getMessage())
                .httpCode(httpStatus)
                .errorCodes(e.getErrorCodes())
                .createdDate(new Date())
                .build();
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotValidException.class)
    public ResponseEntity<ErrorDto> handlerException(EntityNotValidException i,WebRequest webRequest){
        final Integer httpStatus = HttpStatus.BAD_REQUEST.value();
        final ErrorDto errorDto = ErrorDto.builder()
                .error(i.getError())
                .createdDate(new Date())
                .errorCodes(i.getErrorCodes())
                .message(i.getMessage())
                .httpCode(httpStatus)
                .build();
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
}

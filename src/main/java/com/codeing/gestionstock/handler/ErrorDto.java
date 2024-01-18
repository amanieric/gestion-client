package com.codeing.gestionstock.handler;

import com.codeing.gestionstock.exception.ErrorCodes;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Builder
@Getter
@Setter
public class ErrorDto {
    private Integer httpCode;
    private String message;
    private ErrorCodes errorCodes;
    private List<String> error;
    private Date createdDate;
}

package com.codeing.gestionstock.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Result {
    private String message;
    private int HttpCode;
    private Object response;
}

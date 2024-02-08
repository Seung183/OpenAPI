package com.s1.contact.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ApiKeyException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private final String status;

    public ApiKeyException(String message, String stauts){
        super(message);
        this.status = stauts;
    }

    public ApiKeyException(String message){
        this(message, "100");
    }

}

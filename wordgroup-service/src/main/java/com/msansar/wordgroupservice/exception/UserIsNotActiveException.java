package com.msansar.wordgroupservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Daha sonra GlobalExceptionHandler ile yakala
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIsNotActiveException extends RuntimeException{
    public UserIsNotActiveException(String message) {
        super(message);
    }
}

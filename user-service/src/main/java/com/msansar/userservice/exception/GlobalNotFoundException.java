package com.msansar.userservice.exception;
// TODO: tüm exception sınıflarını UserIsNotActive'ye göre düzelt
public class GlobalNotFoundException extends RuntimeException{
    public GlobalNotFoundException(String message) {
        super(message);
    }
    public GlobalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

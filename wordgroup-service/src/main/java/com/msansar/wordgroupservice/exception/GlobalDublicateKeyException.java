package com.msansar.wordgroupservice.exception;

// extends RuntimeException yaparsan bu exception yakalandığında throw eder ve thread daha sonrasında ölür!
// ama runtimeException atınca thread işleme devam edebilir. Bizde devam ettiği sırada kendi mesajımızı atıyoruz.
public class GlobalDublicateKeyException extends RuntimeException{
    public GlobalDublicateKeyException(String message) {
        super(message);
    }

    public GlobalDublicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}

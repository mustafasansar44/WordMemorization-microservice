package com.msansar.wordgroupservice.client;

import com.msansar.wordgroupservice.exception.GlobalNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

/**
 * Bir servis, başka bir servise istek yaparken bir hata aldığında o hatayı handle edip anlamlı hale getirip döndürür.
 */
public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        ExceptionMessage message = null;
        try (InputStream body = response.body().asInputStream()){
            message = new ExceptionMessage(
                    (String) response.headers().get("date").toArray()[0],
                    response.status(),
                    HttpStatus.resolve(response.status()).getReasonPhrase(), // status'un string halini dönüyor.
                    IOUtils.toString(body),
                    response.request().url()
            );
        }catch (IOException e){
            return new Exception(e.getMessage());
        }

        // TODO: Feign'de alacağımız hatalar için buradan yeni hata fırlatacağız.
        switch (response.status()){
            case 404:
                message.message();
                throw new GlobalNotFoundException(message.message());
            default:
                return errorDecoder.decode(s, response);
        }
    }
}

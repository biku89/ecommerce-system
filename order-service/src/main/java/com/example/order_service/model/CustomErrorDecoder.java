package com.example.order_service.model;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

import java.util.Date;

public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 503){
            return new RetryableException(
                    response.status(),
                    "Retry",
                    response.request().httpMethod(),
                    null,
                    new Date(),
                    response.request()
            );
        }
        return errorDecoder.decode(s, response);
    }
}

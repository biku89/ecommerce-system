/*
package com.example.cart_service.FeignTest;

import com.example.cart_service.client.ProductServiceClient;
import com.example.cart_service.model.ProductDTO;
import com.example.cart_service.model.ProductType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.math.BigDecimal;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureWireMock(port = 8585)
@SpringBootTest
public class ProductServiceClientTest {
    @Autowired
    ProductServiceClient productServiceClient;
    @Autowired
    WireMockServer wireMockServer;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    void shouldRetry(){

        ProductDTO productDTO = new ProductDTO(1L,"kom", BigDecimal.valueOf(300.00), ProductType.COMPUTER);

    }
}
*/

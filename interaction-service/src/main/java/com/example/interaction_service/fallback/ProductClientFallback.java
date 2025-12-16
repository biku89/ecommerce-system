package com.example.interaction_service.fallback;

import com.example.interaction_service.client.ProductClient;
import com.example.interaction_service.exception.ServiceUnavailableException;
import com.example.interaction_service.model.PageDTO;
import com.example.interaction_service.model.ProductConfigurationDTO;
import com.example.interaction_service.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductClientFallback implements FallbackFactory<ProductClient> {
    @Override
    public ProductClient create(Throwable cause){
        log.error("Product-service unavailable", cause);

        return new ProductClient() {
            @Override
            public PageDTO<ProductDTO> getAllProducts(Pageable pageable) {
                log.warn("Fallback getAllProducts");
                return null;
            }

            @Override
            public ProductConfigurationDTO getConfiguration(Long id) {
                throw new ServiceUnavailableException("Product-service is unavailable");
            }

            @Override
            public List<ProductDTO> getProductsByType(String type) {
                log.warn("Fallback getProductsByType for type={}", type);
                return List.of();
            }
        };
    }
}

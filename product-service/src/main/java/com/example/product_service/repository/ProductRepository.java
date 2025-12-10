package com.example.product_service.repository;

import com.example.product_service.model.Product;
import com.example.product_service.model.ProductType;
import jakarta.persistence.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByType(ProductType type);
}

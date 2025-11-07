package com.example.repository;

import org.springframework.stereotype.Repository;
import com.example.backend__pasteleria.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByProductEntity(int id);
    
}

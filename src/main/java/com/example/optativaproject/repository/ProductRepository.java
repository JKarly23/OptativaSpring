package com.example.optativaproject.repository;

import com.example.optativaproject.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductsEntity, Long> {
    List<ProductsEntity> findByCategoriaId(Long categoriaId);
}

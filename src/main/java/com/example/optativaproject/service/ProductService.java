package com.example.optativaproject.service;

import com.example.optativaproject.entities.ProductsEntity;
import com.example.optativaproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductsEntity> findAll() {
        return productRepository.findAll();
    }

    public Optional<ProductsEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    public ProductsEntity save(ProductsEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductsEntity> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoriaId(categoryId);
    }
}
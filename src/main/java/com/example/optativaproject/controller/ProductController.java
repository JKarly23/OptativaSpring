package com.example.optativaproject.controller;

import com.example.optativaproject.entities.ProductsEntity;
import com.example.optativaproject.service.CategoryService;
import com.example.optativaproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<ProductsEntity> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsEntity> getProductById(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductsEntity> createProduct(@RequestBody ProductsEntity productEntity) {
        return categoryService.findById(productEntity.getCategoria().getId())
                .map(category -> {
                    productEntity.setCategoria(category);
                    return ResponseEntity.ok(productService.save(productEntity));
                })
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsEntity> updateProduct(@PathVariable Long id, @RequestBody ProductsEntity productEntity) {
        return productService.findById(id)
                .map(existingProduct -> {
                    existingProduct.setNombre(productEntity.getNombre());
                    existingProduct.setPrecio(productEntity.getPrecio());

                    // Actualizamos la categoría si se envía una nueva
                    categoryService.findById(productEntity.getCategoria().getId())
                            .ifPresent(existingProduct::setCategoria);

                    return ResponseEntity.ok(productService.save(existingProduct));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.findById(id).isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductsEntity>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductsEntity> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }
}
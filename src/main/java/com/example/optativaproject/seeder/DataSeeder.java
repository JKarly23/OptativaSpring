package com.example.optativaproject.seeder;

import com.example.optativaproject.entities.CategoryEntity;
import com.example.optativaproject.entities.ProductsEntity;
import com.example.optativaproject.repository.CategoryRepository;
import com.example.optativaproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.util.Arrays;

@Component
public class DataSeeder {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Método que se ejecuta automáticamente al iniciar la aplicación.
     */
    @PostConstruct
    public void seedDatabase() {
        if (categoryRepository.count() == 0 && productRepository.count() == 0) {
            // Crear categorías
            CategoryEntity electronics = new CategoryEntity();
            electronics.setNombre("Electronics");

            CategoryEntity groceries = new CategoryEntity();
            groceries.setNombre("Groceries");

            categoryRepository.saveAll(Arrays.asList(electronics, groceries));

            // Crear productos
            ProductsEntity product1 = new ProductsEntity();
            product1.setNombre("Smartphone");
            product1.setPrecio(699.99);
            product1.setCategoria(electronics);

            ProductsEntity product2 = new ProductsEntity();
            product2.setNombre("Laptop");
            product2.setPrecio(1299.99);
            product2.setCategoria(electronics);

            ProductsEntity product3 = new ProductsEntity();
            product3.setNombre("Bread");
            product3.setPrecio(2.99);
            product3.setCategoria(groceries);

            ProductsEntity product4 = new ProductsEntity();
            product4.setNombre("Milk");
            product4.setPrecio(1.49);
            product4.setCategoria(groceries);

            productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));

            System.out.println("Database seeded successfully!");
        } else {
            System.out.println("Database already seeded.");
        }
    }
}

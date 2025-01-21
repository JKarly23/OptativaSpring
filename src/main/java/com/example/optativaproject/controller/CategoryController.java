package com.example.optativaproject.controller;

import com.example.optativaproject.entities.CategoryEntity;
import com.example.optativaproject.seeder.DataSeeder;
import com.example.optativaproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DataSeeder dataSeeder;

    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity categoryEntity) {
        return categoryService.save(categoryEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity) {
        return categoryService.findById(id)
                .map(existingCategory -> {
                    existingCategory.setNombre(categoryEntity.getNombre());
                    return ResponseEntity.ok(categoryService.save(existingCategory));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (categoryService.findById(id).isPresent()) {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/seed")
    public ResponseEntity<String> seedDatabase() {
        try {
            dataSeeder.seedDatabase();
            return ResponseEntity.ok("Database seeded successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error seeding database: " + e.getMessage());
        }
    }
}

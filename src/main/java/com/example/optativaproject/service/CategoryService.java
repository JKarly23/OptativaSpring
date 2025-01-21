package com.example.optativaproject.service;

import com.example.optativaproject.entities.CategoryEntity;
import com.example.optativaproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public CategoryEntity save(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
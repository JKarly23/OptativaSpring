package com.example.optativaproject.repository;
import com.example.optativaproject.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends  JpaRepository<CategoryEntity, Long> {
}

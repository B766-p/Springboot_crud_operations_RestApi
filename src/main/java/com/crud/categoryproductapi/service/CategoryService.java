package com.crud.categoryproductapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.crud.categoryproductapi.entity.Category;

import java.util.Optional;
public interface CategoryService {
    Page<Category> getAllCategories(Pageable pageable);
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}

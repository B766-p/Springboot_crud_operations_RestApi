package com.crud.categoryproductapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.categoryproductapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

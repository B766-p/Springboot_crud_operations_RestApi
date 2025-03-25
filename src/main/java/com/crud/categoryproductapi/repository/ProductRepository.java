package com.crud.categoryproductapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.categoryproductapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

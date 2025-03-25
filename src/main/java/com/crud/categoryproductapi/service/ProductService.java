package com.crud.categoryproductapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.crud.categoryproductapi.entity.Product;

import java.util.Optional;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}

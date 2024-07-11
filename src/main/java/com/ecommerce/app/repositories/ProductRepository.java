package com.ecommerce.app.repositories;

import com.ecommerce.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("FROM Product")
    List<Product> findAllProducts();

    @Query("FROM Product WHERE category = :category")
    List<Product> findProductsByCategory(@Param("category") String category);
}

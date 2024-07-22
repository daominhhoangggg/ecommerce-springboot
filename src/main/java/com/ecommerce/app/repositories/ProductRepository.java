package com.ecommerce.app.repositories;

import com.ecommerce.app.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT DISTINCT category FROM Product")
    List<String> findAllCategory();

    @Query("FROM Product WHERE id = :id")
    Optional<Product> findProductById(@Param("id") Long id);

    @Query("FROM Product " +
        "WHERE (:search IS NULL OR (name ILIKE %:search% OR long_desc ILIKE %:search% OR short_desc ILIKE %:search%)) " +
        "AND (:category IS NULL OR category = :category)")
    List<Product> searchProducts(@Param("search") String search,@Param("category") String category);
}

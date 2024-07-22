package com.ecommerce.app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ecommerce.app.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("FROM CartItem WHERE customer.id = :id")
    List<CartItem> getCartItemsByCustomerId(@Param("id") Long id);
}

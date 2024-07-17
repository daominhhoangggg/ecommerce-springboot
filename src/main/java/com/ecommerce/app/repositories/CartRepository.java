package com.ecommerce.app.repositories;

import com.ecommerce.app.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ecommerce.app.dto.CustomerCartDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
//    @Query("SELECT c.id, p.id, p.name, p.price, p.img1, cart.count FROM cart JOIN product p on cart.productId = p.id JOIN customer c on cart.customerId = c.id")
//    List<CustomerCartDTO> getCart();
    @Query("SELECT new com.ecommerce.app.dto.CustomerCartDTO(c.customerId, p.id, p.name, p.price, p.img1, c.quantity) " +
        "FROM Cart c JOIN Product p ON c.productId = p.id JOIN Customer cu ON c.customerId = cu.id WHERE c.customerId = :id")
    List<CustomerCartDTO> getCart(@Param("id") Long id);
}

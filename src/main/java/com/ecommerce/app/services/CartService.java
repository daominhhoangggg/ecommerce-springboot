package com.ecommerce.app.services;

import java.util.List;
import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.exception.CartItemException;
import com.ecommerce.app.exception.CustomerException;
import com.ecommerce.app.models.CartItem;

public interface CartService {
    List<CustomerCartDTO> getCart(Long id);
    CartItem addToCart(Long customerId, Long productId, Integer quantity) throws CustomerException;
}

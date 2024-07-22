package com.ecommerce.app.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.models.CartItem;
import com.ecommerce.app.repositories.CartItemRepository;
import com.ecommerce.app.services.CartService;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public List<CustomerCartDTO> getCart(Long id) {
        List<CartItem> cart = cartItemRepository.getCartItemsByCustomerId(id);
            return cart.stream().map(cartItem -> new CustomerCartDTO(
                cartItem.getCustomer().getId(),
                cartItem.getProduct().getId(),
                cartItem.getProduct().getName(),
                cartItem.getProduct().getPrice(),
                cartItem.getProduct().getImg1(),
                cartItem.getQuantity()
            )).collect(Collectors.toList());
    }
}

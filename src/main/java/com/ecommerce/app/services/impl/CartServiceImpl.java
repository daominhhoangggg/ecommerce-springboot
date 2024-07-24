package com.ecommerce.app.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.exception.CartItemException;
import com.ecommerce.app.exception.CustomerException;
import com.ecommerce.app.models.CartItem;
import com.ecommerce.app.models.Customer;
import com.ecommerce.app.models.Product;
import com.ecommerce.app.models.ResponseObject;
import com.ecommerce.app.repositories.CartItemRepository;
import com.ecommerce.app.repositories.CustomerRepository;
import com.ecommerce.app.repositories.ProductRepository;
import com.ecommerce.app.services.CartService;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

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

    @Override
    public CartItem addToCart(Long customerId, Long productId, Integer quantity) throws CustomerException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerException("Customer not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = cartItemRepository.findByCustomerIdAndProductId(customerId, productId);

        if(cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem(customer, product, quantity);
        }

        return cartItemRepository.save(cartItem);
    }
}

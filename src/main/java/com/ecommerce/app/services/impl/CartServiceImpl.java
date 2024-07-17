package com.ecommerce.app.services.impl;

import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.repositories.CartRepository;
import com.ecommerce.app.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository repository;

    @Override
    public List<CustomerCartDTO> getCart(Long id) {
        return repository.getCart(id);
    }
}

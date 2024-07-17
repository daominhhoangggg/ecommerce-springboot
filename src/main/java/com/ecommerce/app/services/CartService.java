package com.ecommerce.app.services;


import com.ecommerce.app.dto.CustomerCartDTO;

import java.util.List;

public interface CartService {
    List<CustomerCartDTO> getCart(Long id);
}

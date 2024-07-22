package com.ecommerce.app.services;

import java.util.List;
import com.ecommerce.app.dto.CustomerCartDTO;

public interface CartService {
    List<CustomerCartDTO> getCart(Long id);
}

package com.ecommerce.app.controllers;

import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class cartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    List<CustomerCartDTO> getCustomerCart(@RequestParam("idUser") Long id) {
        return cartService.getCart(id);
    }
}

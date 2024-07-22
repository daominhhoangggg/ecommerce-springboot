package com.ecommerce.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.services.CartService;

@RestController
@RequestMapping(path = "/api/v1/carts")
public class cartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    List<CustomerCartDTO> getCart(@RequestParam("idUser") Long id) {
        return cartService.getCart(id);
    }
}

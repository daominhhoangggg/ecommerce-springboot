package com.ecommerce.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.exception.CartItemException;
import com.ecommerce.app.exception.CustomerException;
import com.ecommerce.app.models.CartItem;
import com.ecommerce.app.models.ResponseObject;
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

    @PostMapping("/add")
    ResponseEntity<ResponseObject> addToCart(
        @RequestParam("idUser") Long customerId,
        @RequestParam("idProduct") Long productId,
        @RequestParam("count") Integer quantity) throws CustomerException {

        try {
            CartItem result = cartService.addToCart(customerId, productId, quantity);
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Successfully added to cart", result));
        } catch (CustomerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", e.getMessage(), "")
            );
        }
    }
}

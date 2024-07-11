package com.ecommerce.app.controllers;

import com.ecommerce.app.models.Product;
import com.ecommerce.app.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class productController {
    private final ProductRepository repository;

    public productController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Product> getAllProducts() {
        return repository.findAllProducts();
    }
}

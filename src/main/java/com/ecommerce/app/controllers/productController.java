package com.ecommerce.app.controllers;

import com.ecommerce.app.models.Product;
import com.ecommerce.app.models.ResponseObject;
import com.ecommerce.app.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/category")
    ResponseEntity<ResponseObject> getCategory(@RequestParam("category") String category) {
        List<Product> foundProducts;
        if("all".equalsIgnoreCase(category)) {
            foundProducts = repository.findAllProducts();
        } else {
            foundProducts = repository.findProductsByCategory(category);
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query by category successfully", foundProducts)
        );
    }
}

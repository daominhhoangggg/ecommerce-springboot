package com.ecommerce.app.controllers;

import com.ecommerce.app.models.Product;
import com.ecommerce.app.models.ResponseObject;
import com.ecommerce.app.repositories.ProductRepository;
import com.ecommerce.app.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/products")
public class productController {
    private final ProductRepository repository;
    public final ProductService productService;

    public productController(ProductRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    @GetMapping("")
    List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/category")
    ResponseEntity<ResponseObject> getCategory() {
        List<String> listCategory = repository.findAllCategory();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query by category successfully", listCategory)
        );
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getDetail(@PathVariable("id") Long id) {
        Optional<Product> foundProduct = repository.findProductsById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find product with id = " + id, "")
                );
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseObject> getPagination(@RequestParam(value = "search", required = false) String search,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("count") int count,
                                                 @RequestParam("category") String category) {
        if(category.equalsIgnoreCase("all")) category = null;
        Page<Product> result = productService.search(search ,page, count, category);
        List<Product> foundProducts = result.getContent();

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Search product successfully", foundProducts)
        );
    }
}

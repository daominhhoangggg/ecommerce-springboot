package com.ecommerce.app.controllers;

import com.ecommerce.app.models.Product;
import com.ecommerce.app.models.ResponseObject;
import com.ecommerce.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class productController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    List<Product> getAllProducts() {
        return productService.getAllProducts(1, 8);
    }

    @GetMapping("/category")
    ResponseEntity<ResponseObject> getCategory() {
        List<String> listCategory = productService.getAllCategory();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query by category successfully", listCategory)
        );
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getDetail(@PathVariable("id") Long id) {
        Product foundProduct = productService.findProductById(id);
        return foundProduct != null ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find product with id = " + id, "")
                );
    }

    @GetMapping("/pagination")
    List<Product> getPagination(@RequestParam(value = "search", required = false) String search,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("count") int count,
                                                 @RequestParam("category") String category) {
        Page<Product> result;
        if(category.equalsIgnoreCase("all")) {
            result = productService.search(search ,page, count, null);
        } else {
            result = productService.search(search ,page, count, category);
        }

        return result.getContent();
    }
}

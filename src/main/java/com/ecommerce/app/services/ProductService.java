package com.ecommerce.app.services;

import com.ecommerce.app.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
 List<Product> getAllProducts();
 List<String> getAllCategory();
 Page<Product> search(String search ,int page, int count, String category);
 Product findProductById(Long id);
}

package com.ecommerce.app.services;

import com.ecommerce.app.models.Product;
import org.springframework.data.domain.Page;

public interface IProduct {
 Page<Product> search(String search ,int page, int count, String category);
 void save(Product product);
 Product get(Long id);
 void delete(Long id);
}

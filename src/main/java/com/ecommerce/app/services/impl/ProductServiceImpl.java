package com.ecommerce.app.services.impl;

import com.ecommerce.app.models.Product;
import com.ecommerce.app.repositories.ProductRepository;
import com.ecommerce.app.services.CustomerService;
import com.ecommerce.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    private CustomerService customerService;

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }
    @Override
    public  List<String> getAllCategory() {
        return productRepository.findAllCategory();
    }
    @Override
    public Page<Product> search(String search, int page, int count, String category) {
        Pageable pageable = PageRequest.of(page-1, count);
        List<Product> products = productRepository.searchProducts(search, category);

        int startIndex = (int) pageable.getOffset();
        int endIndex = (int) Math.min(startIndex + pageable.getPageSize(), products.size());

        List<Product> pageContent = products.subList(startIndex, endIndex);

        return new PageImpl<>(pageContent, pageable, products.size());
    }
    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

}

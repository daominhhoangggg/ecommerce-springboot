package com.ecommerce.app.services.impl;

import com.ecommerce.app.models.Product;
import com.ecommerce.app.repositories.ProductRepository;
import com.ecommerce.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public  List<String> getAllCategory() {
        return repository.findAllCategory();
    }

    @Override
    public Page<Product> search(String search, int page, int count, String category) {
        Pageable pageable = PageRequest.of(page-1, count);
        return repository.searchProducts(search, pageable, category);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

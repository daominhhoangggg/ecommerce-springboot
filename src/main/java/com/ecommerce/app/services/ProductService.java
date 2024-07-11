package com.ecommerce.app.services;

import com.ecommerce.app.models.Product;
import com.ecommerce.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProduct{
    @Autowired
    ProductRepository repository;

    @Override
    public Page<Product> search(int page, int count) {
        Pageable pageable = PageRequest.of(page-1, count);
        return repository.findAll(pageable);
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

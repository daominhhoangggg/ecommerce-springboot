package com.ecommerce.app.services.impl;

import com.ecommerce.app.models.Customer;
import com.ecommerce.app.repositories.CustomerRepository;
import com.ecommerce.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

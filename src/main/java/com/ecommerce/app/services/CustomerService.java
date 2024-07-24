package com.ecommerce.app.services;

import com.ecommerce.app.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void save(Customer customer);
    void delete(Long id);
}

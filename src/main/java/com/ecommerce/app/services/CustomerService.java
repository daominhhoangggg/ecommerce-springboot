package com.ecommerce.app.services;

import com.ecommerce.app.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer get(Long id);
    void save(Customer customer);
    void delete(Long id);
}

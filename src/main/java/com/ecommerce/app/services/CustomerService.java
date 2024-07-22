package com.ecommerce.app.services;

import com.ecommerce.app.dto.CustomerCartDTO;
import com.ecommerce.app.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void save(Customer customer);
    void delete(Long id);
}

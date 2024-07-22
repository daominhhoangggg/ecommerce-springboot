package com.ecommerce.app.controllers;

import com.ecommerce.app.models.Customer;
import com.ecommerce.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class customerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}

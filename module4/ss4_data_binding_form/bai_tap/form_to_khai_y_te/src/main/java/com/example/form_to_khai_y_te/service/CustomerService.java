package com.example.form_to_khai_y_te.service;

import com.example.form_to_khai_y_te.entity.Customer;

import java.util.List;

public interface CustomerService {
    void save (Customer customer);
    List<Customer> display();
}

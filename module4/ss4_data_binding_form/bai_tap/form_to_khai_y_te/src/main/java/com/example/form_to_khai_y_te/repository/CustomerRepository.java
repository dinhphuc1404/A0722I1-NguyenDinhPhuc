package com.example.form_to_khai_y_te.repository;

import com.example.form_to_khai_y_te.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    void save (Customer customer);
    List<Customer> display();
}

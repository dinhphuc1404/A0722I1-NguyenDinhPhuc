package com.example.case_study_jsp.service;

import com.example.case_study_jsp.model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(String id);
    void update(Customer customer);
    Customer findById(String id);

}

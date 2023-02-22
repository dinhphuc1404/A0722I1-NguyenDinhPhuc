package com.example.case_study_jsp.reponsitory;

import com.example.case_study_jsp.model.customer.Customer;

import java.util.List;

public interface CustomerRepositories {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(String id);
    void update(Customer customer);
    Customer findById(String id);
}

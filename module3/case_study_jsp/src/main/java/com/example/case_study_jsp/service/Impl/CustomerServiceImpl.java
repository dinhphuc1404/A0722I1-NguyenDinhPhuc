package com.example.case_study_jsp.service.Impl;

import com.example.case_study_jsp.model.customer.Customer;
import com.example.case_study_jsp.model.validator.Validator;
import com.example.case_study_jsp.reponsitory.CustomerRepositories;
import com.example.case_study_jsp.reponsitory.Impl.CustomerRepositoriesImpl;
import com.example.case_study_jsp.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepositories customerRepositories = new CustomerRepositoriesImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepositories.save(customer);
    }


    @Override
    public void delete(String id) {
        customerRepositories.delete(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepositories.update(customer);
    }


    @Override
    public Customer findById(String id) {
        return customerRepositories.findById(id);
    }
}

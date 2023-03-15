package com.example.form_to_khai_y_te.service;

import com.example.form_to_khai_y_te.entity.Customer;
import com.example.form_to_khai_y_te.repository.CustomerRepository;
import com.example.form_to_khai_y_te.repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> display() {
        return customerRepository.display();
    }
}

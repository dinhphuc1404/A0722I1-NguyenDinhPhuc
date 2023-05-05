package com.example.case_study.service;

import com.example.case_study.repository.customer.ICustomerRepository;
import com.example.case_study.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepositories;

    @Override
    public List<Customer> findAll() {
        return customerRepositories.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepositories.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
//        customer.setCustomerBirthday(DateFormatter.dateFormat(customer.getCustomerBirthday()));
        customerRepositories.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepositories.deleteById(id);
    }

    @Override
    public Page<Customer> findCustomerByCustomerName(String customerName, Pageable pageable) {
        return customerRepositories.findCustomerByCustomerName(customerName, pageable);
    }
}

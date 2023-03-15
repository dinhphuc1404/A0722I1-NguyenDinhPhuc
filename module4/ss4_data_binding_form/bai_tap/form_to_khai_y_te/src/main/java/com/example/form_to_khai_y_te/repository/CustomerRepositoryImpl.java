package com.example.form_to_khai_y_te.repository;

import com.example.form_to_khai_y_te.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public List<Customer> display() {
        return customerList;
    }
}

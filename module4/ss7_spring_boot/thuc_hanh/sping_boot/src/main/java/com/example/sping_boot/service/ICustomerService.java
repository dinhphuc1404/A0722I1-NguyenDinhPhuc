package com.example.sping_boot.service;

import com.example.sping_boot.model.Customer;
import com.example.sping_boot.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface ICustomerService extends IGeneralService<Customer> {
}

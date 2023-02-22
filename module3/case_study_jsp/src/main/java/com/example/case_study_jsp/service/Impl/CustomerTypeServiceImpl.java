package com.example.case_study_jsp.service.Impl;

import com.example.case_study_jsp.model.customer.CustomerType;
import com.example.case_study_jsp.reponsitory.CustomerTypeRepositories;
import com.example.case_study_jsp.reponsitory.Impl.CustomerTypeRepositoriesImpl;
import com.example.case_study_jsp.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepositories customerTypeRepositories = new CustomerTypeRepositoriesImpl();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepositories.findAll();
    }
}

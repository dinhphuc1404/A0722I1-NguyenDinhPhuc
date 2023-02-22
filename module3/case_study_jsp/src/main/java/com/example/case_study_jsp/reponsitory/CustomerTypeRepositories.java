package com.example.case_study_jsp.reponsitory;

import com.example.case_study_jsp.model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeRepositories {
    List<CustomerType> findAll();
}

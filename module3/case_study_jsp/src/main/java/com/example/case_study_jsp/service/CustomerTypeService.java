package com.example.case_study_jsp.service;

import com.example.case_study_jsp.model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}

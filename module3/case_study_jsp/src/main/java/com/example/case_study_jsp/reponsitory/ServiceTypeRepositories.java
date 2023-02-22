package com.example.case_study_jsp.reponsitory;

import com.example.case_study_jsp.model.service.ServiceType;

import java.util.List;

public interface ServiceTypeRepositories {
    List<ServiceType> findAll();
}

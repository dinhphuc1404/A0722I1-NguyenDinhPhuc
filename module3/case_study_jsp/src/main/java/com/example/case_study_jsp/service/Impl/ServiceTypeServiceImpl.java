package com.example.case_study_jsp.service.Impl;

import com.example.case_study_jsp.model.service.ServiceType;
import com.example.case_study_jsp.reponsitory.Impl.ServiceTypeRepositoriesImpl;
import com.example.case_study_jsp.reponsitory.ServiceTypeRepositories;
import com.example.case_study_jsp.service.ServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService {
    ServiceTypeRepositories serviceTypeRepositories = new ServiceTypeRepositoriesImpl();
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepositories.findAll();
    }
}

package com.example.case_study_jsp.service.Impl;

import com.example.case_study_jsp.model.service.RentType;
import com.example.case_study_jsp.reponsitory.Impl.RentTypeRepositoriesImpl;
import com.example.case_study_jsp.reponsitory.RenTypeRepositories;
import com.example.case_study_jsp.service.RentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RenTypeRepositories renTypeRepositories = new RentTypeRepositoriesImpl();
    @Override
    public List<RentType> findAll() {
        return renTypeRepositories.findAll();
    }
}

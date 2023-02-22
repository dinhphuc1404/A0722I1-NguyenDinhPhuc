package com.example.case_study_jsp.service;

import com.example.case_study_jsp.model.service.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    List<String> findAllStandardRoom ();
    void save(Service service);
    void delete(int id);
    void update(Service service);
    Service findById(int id);
}

package com.example.case_study_jsp.reponsitory;

import com.example.case_study_jsp.model.service.Service;

import java.util.List;

public interface ServiceRepositories {
    List<Service> findAll();
    List<String> findAllStandardRoom ();
    void save(Service service);
    void delete(int id);
    void update(Service service);
    Service findById(int id);
}

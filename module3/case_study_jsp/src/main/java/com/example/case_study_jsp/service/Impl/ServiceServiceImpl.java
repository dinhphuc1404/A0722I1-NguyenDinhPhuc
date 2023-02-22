package com.example.case_study_jsp.service.Impl;

import com.example.case_study_jsp.model.service.Service;
import com.example.case_study_jsp.reponsitory.Impl.ServiceRepositoriesImpl;
import com.example.case_study_jsp.reponsitory.ServiceRepositories;
import com.example.case_study_jsp.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    private ServiceRepositories serviceRepositories = new ServiceRepositoriesImpl();
    @Override
    public List<Service> findAll() {
        return serviceRepositories.findAll();
    }

    @Override
    public List<String> findAllStandardRoom() {
        return serviceRepositories.findAllStandardRoom();
    }

    @Override
    public void save(Service service) {
        serviceRepositories.save(service);
    }

    @Override
    public void delete(int id) {
        serviceRepositories.delete(id);
    }

    @Override
    public void update(Service service) {
        serviceRepositories.update(service);
    }

    @Override
    public Service findById(int id) {
        return serviceRepositories.findById(id);
    }
}

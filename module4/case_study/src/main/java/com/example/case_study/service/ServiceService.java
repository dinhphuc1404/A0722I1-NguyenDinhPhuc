package com.example.case_study.service;

import com.example.case_study.repository.service.IRentTypeRepository;
import com.example.case_study.repository.service.IServiceRepository;
import com.example.case_study.repository.service.IServiceTypeRepository;
import com.example.case_study.entity.RentType;
import com.example.case_study.entity.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    IServiceRepository serviceRepositories;

    @Autowired
    IServiceTypeRepository serviceTypeRepositories;

    @Autowired
    IRentTypeRepository rentTypeRepositories;

    @Override
    public List<com.example.case_study.entity.Service> findAll() {
        return serviceRepositories.findAll();
    }

    @Override
    public Page<com.example.case_study.entity.Service> findAll(Pageable pageable) {
        return serviceRepositories.findAll(pageable);
    }

    @Override
    public com.example.case_study.entity.Service save(com.example.case_study.entity.Service service) {
        return serviceRepositories.save(service);
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepositories.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepositories.findAll();
    }
}

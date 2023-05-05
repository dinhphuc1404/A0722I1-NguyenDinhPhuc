package com.example.case_study.service;

import com.example.case_study.entity.RentType;
import com.example.case_study.entity.Service;
import com.example.case_study.entity.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();
    Page<Service> findAll(Pageable pageable);
    Service save(Service service);
    List<RentType> findAllRentType();
    List<ServiceType> findAllServiceType();
}

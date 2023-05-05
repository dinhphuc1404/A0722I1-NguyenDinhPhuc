package com.example.case_study.repository.customer;

import com.example.case_study.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerType extends JpaRepository<CustomerType, Integer> {
}

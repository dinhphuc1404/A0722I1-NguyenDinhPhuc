package com.example.case_study.repository.employee;

import com.example.case_study.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findCustomerByEmployeeName(String name, Pageable p);
}

package com.example.case_study_jsp.service;

import com.example.case_study_jsp.model.employee.Division;
import com.example.case_study_jsp.model.employee.EducationDegree;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.model.employee.Position;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void create(Employee employee);
    void edit(Employee employee);
    void delete(int id);
}

package com.example.case_study_jsp.service.Impl;

import com.example.case_study_jsp.model.employee.Division;
import com.example.case_study_jsp.model.employee.EducationDegree;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.model.employee.Position;
import com.example.case_study_jsp.reponsitory.EmployeeRepositories;
import com.example.case_study_jsp.reponsitory.Impl.EmployeeRepositoriesImpl;
import com.example.case_study_jsp.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepositories employeeRepositories = new EmployeeRepositoriesImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepositories.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepositories.findById(id);
    }

    @Override
    public void create(Employee employee) {
        employeeRepositories.create(employee);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepositories.edit(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepositories.delete(id);
    }
}

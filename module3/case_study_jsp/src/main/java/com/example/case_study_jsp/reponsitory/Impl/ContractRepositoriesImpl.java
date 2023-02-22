package com.example.case_study_jsp.reponsitory.Impl;

import com.example.case_study_jsp.model.contract.Contract;
import com.example.case_study_jsp.model.customer.Customer;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.model.service.Service;
import com.example.case_study_jsp.reponsitory.ContractRepositories;

import java.util.List;

public class ContractRepositoriesImpl implements ContractRepositories {
    @Override
    public List<Contract> findAllContract() {
        return null;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return null;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return null;
    }

    @Override
    public List<Service> fillAllService() {
        return null;
    }

    @Override
    public Contract findById(int id) {
        return null;
    }

    @Override
    public void create(Contract contract) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Contract contract) {

    }
}

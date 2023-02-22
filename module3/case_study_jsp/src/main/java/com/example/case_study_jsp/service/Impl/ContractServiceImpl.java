package com.example.case_study_jsp.service.Impl;

import com.example.case_study_jsp.model.contract.Contract;
import com.example.case_study_jsp.model.customer.Customer;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.model.service.Service;
import com.example.case_study_jsp.reponsitory.ContractRepositories;
import com.example.case_study_jsp.reponsitory.Impl.ContractRepositoriesImpl;
import com.example.case_study_jsp.service.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepositories contractRepositories = new ContractRepositoriesImpl();
    @Override
    public List<Contract> findAllContract() {
        return contractRepositories.findAllContract();
    }

    @Override
    public List<Employee> findAllEmployee() {
        return contractRepositories.findAllEmployee();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return contractRepositories.findAllCustomer();
    }

    @Override
    public List<Service> findAllService() {
        return contractRepositories.fillAllService();
    }

    @Override
    public Contract findById(int id) {
        return contractRepositories.findById(id);
    }

    @Override
    public void create(Contract contract) {
        contractRepositories.create(contract);
    }

    @Override
    public void delete(int id) {
        contractRepositories.delete(id);
    }

    @Override
    public void update(Contract contract) {
        contractRepositories.update(contract);
    }
}

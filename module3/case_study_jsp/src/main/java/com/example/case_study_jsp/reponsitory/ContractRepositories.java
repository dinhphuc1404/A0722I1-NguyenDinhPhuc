package com.example.case_study_jsp.reponsitory;

import com.example.case_study_jsp.model.contract.Contract;
import com.example.case_study_jsp.model.customer.Customer;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.model.service.Service;

import java.util.List;

public interface ContractRepositories {
    List<Contract> findAllContract();
    List<Employee> findAllEmployee();
    List<Customer> findAllCustomer();
    List<Service> fillAllService();
    Contract findById(int id);
    void create(Contract contract);
    void delete(int id);
    void update(Contract contract);
}

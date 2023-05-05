package com.example.case_study.service;

import com.example.case_study.repository.employee.*;
import com.example.case_study.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepositories;

    @Autowired
    IEducationDegreeRepository educationDegreeRepositories;

    @Autowired
    IDivisionRepository divisionRepositories;

    @Autowired
    IPositionRepository positionRepositories;

    @Autowired
    IUserRepository userRepositories;

    @Autowired
    IRoleRepository roleRepositories;

    @Override
    public List<Employee> findAll() {
        return employeeRepositories.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepositories.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        User user = new User(employee.getUser().getUsername(), "123123");
        // mã hoá mật khẩu
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        int positionId = employee.getPosition().getPositionId();
        Set<Role> roleSet = new HashSet<>();
        // lưu tài khoản employee kèm role
        if(positionId == 5){ // Quản lý
            Role roleManager = roleRepositories.findById(2).orElse(null);
            roleSet.add(roleManager);
            user.setRoles(roleSet);
        } else if(positionId==6) { // Giám đốc
            Role roleManager = roleRepositories.findById(3).orElse(null);
            roleSet.add(roleManager);
            user.setRoles(roleSet);
        } else { // Nhân viên ình thường
            Role roleManager = roleRepositories.findById(1).orElse(null);
            roleSet.add(roleManager);
            user.setRoles(roleSet);
        }
        // cập nhật lại user đã mã hoá mật khẩu vào employee
        employee.setUser(user);
        // lưu thông tin employee
        employeeRepositories.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepositories.deleteById(id);
    }

    @Override
    public Page<Employee> findCustomerByEmployeeName(String name, Pageable pageable) {
        return employeeRepositories.findCustomerByEmployeeName(name,pageable);
    }

    @Override
    public List<EducationDegree> findAllDegree() {
        return educationDegreeRepositories.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepositories.findAll();
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepositories.findAll();
    }
}

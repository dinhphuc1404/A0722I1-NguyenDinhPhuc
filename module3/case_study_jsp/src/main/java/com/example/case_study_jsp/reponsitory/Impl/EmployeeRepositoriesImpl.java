package com.example.case_study_jsp.reponsitory.Impl;

import com.example.case_study_jsp.model.employee.Division;
import com.example.case_study_jsp.model.employee.EducationDegree;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.model.employee.Position;
import com.example.case_study_jsp.reponsitory.DBConnection;
import com.example.case_study_jsp.reponsitory.EmployeeRepositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoriesImpl implements EmployeeRepositories {
    public static final String SELECT_ALL_EMPLOYEE = "select employee.employee_id,employee.employee_name,employee.employee_birthday,employee.employee_id_card,employee.employee_salary,\n" +
            " employee.employee_phone,employee.employee_email,employee.employee_address,positionn.position_name,education_degree.education_degree_name,\n" +
            " division.division_name,user.username,user.password from employee inner join positionn on positionn.position_id = employee.position_id\n" +
            "            inner join education_degree on education_degree.education_degree_id = employee.education_degree_id \n" +
            "            inner join division on division.division_id = employee.division_id\n" +
            "            inner join user on user.username = employee.username;";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO customer" + " (customer_id,customer_type_id,customer_name,customer_birthday" +
            ",customer_gender,customer_id_card,customer_phone,customer_email,customer_address)VALUES"+" (?, ?, ? ,?,?, ?, ? ,?,?);";
    @Override
    public List<Employee> findAll()   {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("employee_name");
                Date employeeBirthday = rs.getDate("employee_birthday");
                String employeeIdCard = rs.getString("employee_id_card");
                double employeeSalary = rs.getDouble("employee_salary");
                String employeePhone = rs.getString("employee_phone");
                String employeeEmail = rs.getString("employee_email");
                String employeeAddress = rs.getString("employee_address");
                String positionName = rs.getString("position_name");
                String educationDegreeName = rs.getString("education_degree_name");
                String divisionName = rs.getString("division_name");
                String userName = rs.getString("username");
                String password = rs.getString("password");
                Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress,
                        positionName,  educationDegreeName,
                        divisionName, userName, password);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public void edit(Employee employee) {

    }

    @Override
    public void delete(int id) {

    }
}

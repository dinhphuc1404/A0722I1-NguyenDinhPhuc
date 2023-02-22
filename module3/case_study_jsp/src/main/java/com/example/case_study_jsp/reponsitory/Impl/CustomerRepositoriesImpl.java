package com.example.case_study_jsp.reponsitory.Impl;

import com.example.case_study_jsp.model.customer.Customer;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.reponsitory.CustomerRepositories;
import com.example.case_study_jsp.reponsitory.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoriesImpl implements CustomerRepositories {
    public static final String SELECT_ALL_CUSTOMER= " select customer.customer_id, customer.customer_code, customer_type.customer_type_name,customer.customer_name,customer.customer_birthday,customer.customer_gender,\n" +
            "customer.customer_id_card,customer.customer_phone,customer.customer_email,customer.customer_address \n" +
            "from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id;";
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int customerId = rs.getInt("customer_id");
                String customerCode = rs.getString("customer_code");
                String customerTypName = rs.getString("customer_type_name");
                String customerName = rs.getString("customer_name");
                Date customerBirthday = rs.getDate("customer_birthday");
                int customerGender = rs.getInt("customer_gender");
                String customerIdCard = rs.getString("customer_id_card");
                String customerPhone = rs.getString("customer_phone");
                String customerEmail = rs.getString("customer_email");
                String customerAddress = rs.getString("customer_address");
                Customer customer = new Customer(customerId,customerCode,customerTypName,customerName,customerBirthday,customerGender,
                        customerIdCard,customerPhone,customerEmail,customerAddress);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public Customer findById(String id) {
        return null;
    }
}

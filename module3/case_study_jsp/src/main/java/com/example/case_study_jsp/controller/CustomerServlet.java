package com.example.case_study_jsp.controller;

import com.example.case_study_jsp.model.customer.Customer;
import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.service.CustomerService;
import com.example.case_study_jsp.service.Impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action = "";
        switch (action){
            case "create":
                //showFormCreate(request,response);
                break;
            case "edit":
                //showFormEdit(request,response);
                break;
            case "delete":
                //deleteEmployee(request,response);
                break;
            default:
                showListCustomer(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        System.out.println(customerList.size());
        request.setAttribute("listCustomer", customerList);
        request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
    }
}

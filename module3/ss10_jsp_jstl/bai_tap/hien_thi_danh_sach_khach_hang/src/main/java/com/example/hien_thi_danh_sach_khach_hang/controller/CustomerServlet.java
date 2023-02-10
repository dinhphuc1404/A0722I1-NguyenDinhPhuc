package com.example.hien_thi_danh_sach_khach_hang.controller;

import com.example.hien_thi_danh_sach_khach_hang.model.Customer;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàng","1983-08-20","Hà Nội","1.png"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","1.png"));
        customerList.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định","1.png"));
        customerList.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","1.png"));
        customerList.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","1.png"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("list", customerList);
    request.getRequestDispatcher("list_customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

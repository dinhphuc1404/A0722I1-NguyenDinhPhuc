package com.example.quan_ly_dien_thoai.controller;

import com.example.quan_ly_dien_thoai.model.Category;
import com.example.quan_ly_dien_thoai.model.Phone;
import com.example.quan_ly_dien_thoai.service.PhoneServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhoneServlet", value = "/phone")
public class PhoneServlet extends HttpServlet {
    private PhoneServiceImpl phoneService = new PhoneServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case"create":
                showCreate(request,response);
                break;
            case "update":
                showUpdate(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Phone phone = phoneService.findById(id);
        request.setAttribute("phone ", phone);
        request.getRequestDispatcher("/phone/update.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        phoneService.deletePhone(id);
        showList(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/phone/create.jsp");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> phoneList =phoneService.findAll();
        System.out.println(phoneList.size());
        request.setAttribute("phoneList",phoneList);
        request.getRequestDispatcher("/phone/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
                update(request,response);
                break;
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int id_danh_muc = Integer.parseInt(request.getParameter("id_danh_muc"));
        Phone phone = new Phone(id,name,price,id_danh_muc);
        phoneService.updatePhone(phone);
        response.sendRedirect("/phone");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int id_danh_muc = Integer.parseInt(request.getParameter("id_danh_muc"));

        Phone phone = new Phone(name,price,id_danh_muc);
        phoneService.addNewPhone(phone);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/phone/create.jsp");
        showList(request,response);

    }
}

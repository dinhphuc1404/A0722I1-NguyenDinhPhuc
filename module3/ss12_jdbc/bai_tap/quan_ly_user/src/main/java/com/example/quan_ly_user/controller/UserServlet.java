package com.example.quan_ly_user.controller;

import com.example.quan_ly_user.model.User;
import com.example.quan_ly_user.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "update":
                showUpdateForm(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "create":
                showCreateForm(request,response);
                break;
            case "sort":
                goSort(request,response);
                break;
            case "search":
                goSearch(request,response);
                break;
            default:
                showListUsers(request,response);
                break;
        }
    }

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        List<User> userListSearch = new ArrayList<>();
        for(User user : userService.findAllUser()){
            if(user.getCountry().equals(country)){
                userListSearch.add(user);
            }
        }
        request.setAttribute("listUser", userListSearch);
        request.getRequestDispatcher("user/list.jsp").forward(request,response);
    }

    private void goSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.sort();
        System.out.println(userList.size());
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/user/create.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        showListUsers(request,response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user/update.jsp").forward(request,response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id,name,email,country);
        userService.updateUser(user);
        response.sendRedirect("/user");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name,email,country);
        userService.addNewUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/create.jsp");
        showListUsers(request,response);

    }

    private void showListUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.findAllUser();
        System.out.println(userList.size());
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request,response);
    }
}

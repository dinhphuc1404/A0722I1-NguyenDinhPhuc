package com.example.case_study_jsp.controller;

import com.example.case_study_jsp.reponsitory.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        PrintWriter out = response.getWriter();
//        try {
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            boolean isValid = DBConnection.checkLogin(username,password);
//            if (isValid){
//                HttpSession session = request.getSession();
//                session.getAttribute("username");
//                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("home.jsp");
//                dispatcher.forward(request,response);
//
//            }else {
//                System.out.println("Đăng nhập thất bại");
//                request.setAttribute("message","Tên đăng nhập hoặc mật khẩu không đúng");
//                request.getRequestDispatcher("index.jsp").forward(request,response);
//            }
//        }finally {
//            out.close();
//        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if("admin".equals(username) && "123".equals(password)){
            System.out.println("Đăng nhập thành công");
            if(request.getParameter("chkRemember") != null){
                Cookie co_username = new Cookie("co_username",username);
                Cookie co_password = new Cookie("co_password",password);
                co_username.setMaxAge(180); //2p
                co_password.setMaxAge(180); //2p
                response.addCookie(co_username);
                response.addCookie(co_password);
            }
            session.setAttribute("session_login",username);
            response.sendRedirect("/home.jsp");
        } else {
            System.out.println("Đăng nhập thất bại");
            request.setAttribute("message","Tên đăng nhập hoặc mật khẩu không đúng");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}

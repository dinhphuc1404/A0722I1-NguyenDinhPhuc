package com.example.quan_ly_sinh_vien.controller;

import com.example.quan_ly_sinh_vien.model.Student;
import com.example.quan_ly_sinh_vien.service.IStudentService;
import com.example.quan_ly_sinh_vien.service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {

    private IStudentService service = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if(action==null){
        action="";
    }
    switch (action){
        case "create":
            showCreate(request,response);
            break;
        case "edit":
            showEdit(request,response);
            break;
        default:
            showStudentList(request,response);
    }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("studentId"));
        Student student = service.selectStudent(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", service.findAall());
        request.getRequestDispatcher("/student/list.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/student/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
            createStudent(request, response);
            case "edit":
                updateStudent(request,response);
            break;
            default:
                showStudentList(request,response);
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("studentName");
        int age = Integer.parseInt(request.getParameter("studentAge"));
        Student student = new Student(id,name,age);
        service.edit(student);
        response.sendRedirect("/student");
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        int studentAge = Integer.parseInt(request.getParameter("studentAge"));
        Student student = new Student(studentId,studentName,studentAge);
        service.save(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/create.jsp");
        showStudentList(request,response);

    }
}

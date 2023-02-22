package com.example.case_study_jsp.controller;

import com.example.case_study_jsp.model.employee.Employee;
import com.example.case_study_jsp.service.EmployeeService;
import com.example.case_study_jsp.service.Impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action = "";
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                //showFormEdit(request,response);
                break;
            case "delete":
                //deleteEmployee(request,response);
                break;
            case "list":
                showListEmployee(request,response);
            default:
                showListEmployee(request,response);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/employee/create");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        Date employeeBirthday = Date.valueOf(request.getParameter("employeeBirthday"));
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        String positionName = request.getParameter("positionName");
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        String educationDegreeName = request.getParameter("educationDegreeName");
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String divisionName = request.getParameter("divisionName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,employeeSalary,
                employeePhone,employeeEmail,employeeAddress,positionId,positionName,educationDegreeId,
                educationDegreeName,divisionId,divisionName,username,password);
        employeeService.edit(employee);
        showListEmployee(request,response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        Date employeeBirthday = Date.valueOf(request.getParameter("employeeBirthday"));
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        //String positionName = request.getParameter("positionName");
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        //String educationDegreeName = request.getParameter("educationDegreeName");
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        //String divisionName = request.getParameter("divisionName");
        String username = request.getParameter("username");
        //String password = request.getParameter("password");

        Employee employee = new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,employeeSalary,
                employeePhone,employeeEmail,employeeAddress,positionId,educationDegreeId,
                divisionId,username);
        employeeService.create(employee);
        showListEmployee(request,response);
    }
    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAll();
        System.out.println(employeeList.size());
        request.setAttribute("listEmployee", employeeList);
        request.getRequestDispatcher("/employee/list.jsp").forward(request, response);
    }
}

package com.example.quan_ly_thue_phong_tro.controller;

import com.example.quan_ly_thue_phong_tro.model.Room;
import com.example.quan_ly_thue_phong_tro.service.RomServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "RoomServlet", value = "/room")
public class RoomServlet extends HttpServlet {
    private RomServiceImpl romService = new RomServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action= "";
        }
        switch (action){
            case "update":
                showUpdate(request,response);
                break;
            case "create":
                showCreate(request,response);
                break;
            case "search":
               goSearch(request,response);
                break;
            case "list":
                showList(request,response);
                break;
            case "sort":
               // goSort(request,response);
                break;
            default:
                showList(request,response);
                break;

        }
    }

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        List<Room> roomList = romService.search(name);
        request.setAttribute("listRoom",roomList);
        request.getRequestDispatcher("/room/list.jsp").forward(request,response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Room room = romService.findById(id);
        request.setAttribute("room", room);
        request.getRequestDispatcher("/room/update.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/room/create.jsp");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> roomList = romService.findAll();
        System.out.println(roomList.size());
        request.setAttribute("listRoom", roomList);
        request.getRequestDispatcher("/room/list.jsp").forward(request,response);
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
            case "delete":
               delete(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        romService.delete(id);
        showList(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String phone = request.getParameter("phone");
        Date day = Date.valueOf(request.getParameter("day"));
        String tenThanhToan = request.getParameter("pay");
        Room room = new Room(id,name,phone,day,tenThanhToan);
        romService.update(room);
        response.sendRedirect("/room");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String phone = request.getParameter("phone");
        Date day = Date.valueOf(request.getParameter("day"));
        String tenThanhToan = request.getParameter("pay");
        Room room = new Room(name,phone,day,tenThanhToan);
        romService.add(room);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/room/create.jsp");
        showList(request,response);

    }
}

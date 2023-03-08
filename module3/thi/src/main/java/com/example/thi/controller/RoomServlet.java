package com.example.thi.controller;

import com.example.thi.model.Room;
import com.example.thi.service.RoomServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "RoomServlet", value = "/room")
public class RoomServlet extends HttpServlet {
    private RoomServiceImpl roomService = new RoomServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action= "";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "search":
                goSearchLoaiMatBang(request,response);
                break;
            case "search1":
                goSearchTang(request,response);
                break;
            case "search2":
                goSearchGiaChoThue(request,response);
                break;
            case "list":
                showList(request,response);
                break;
            case "sort":
                goSort(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void goSearchGiaChoThue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double giaTien = Double.parseDouble(request.getParameter("searchGiaChoThue"));
        List<Room> roomList = roomService.searchGia(giaTien);
        request.setAttribute("listRoom", roomList);
        request.getRequestDispatcher("/room/list.jsp").forward(request,response);
    }

    private void goSearchTang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tang = Integer.parseInt(request.getParameter("searchTang"));
        List<Room> roomList = roomService.searchTang(tang);
        request.setAttribute("listRoom", roomList);
        request.getRequestDispatcher("/room/list.jsp").forward(request,response);
    }

    private void goSearchLoaiMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loaiMatBang=request.getParameter("searchloaimatbang");
        List<Room> roomList = roomService.searchLoaiMatBang(loaiMatBang);
        request.setAttribute("listRoom", roomList);
        request.getRequestDispatcher("/room/list.jsp").forward(request,response);
    }

    private void goSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> roomList = roomService.sort();
        System.out.println(roomList.size());
        request.setAttribute("listRoom", roomList);
        request.getRequestDispatcher("/room/list.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/room/create.jsp");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> roomList = roomService.findAll();
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

            case "delete":
                delete(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        roomService.delete(id);
        showList(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maMatBang =request.getParameter("maMatBang");
        String trangThai = request.getParameter("trangThai");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loaiMatBang = request.getParameter("loaiMatBang");
        double giaTien = Double.parseDouble(request.getParameter("giaTien"));
        String moTa = request.getParameter("moTa");
        Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
        Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
        Room room = new Room(maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,moTa,ngayBatDau,ngayKetThuc);
        roomService.add(room);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room/create.jsp");
        showList(request,response);
    }
}

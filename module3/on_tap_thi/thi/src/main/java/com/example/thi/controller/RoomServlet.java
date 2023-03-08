package com.example.thi.controller;

import com.example.thi.model.DatPhong;
import com.example.thi.service.DatPhongServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "RoomServlet", value = "/room")
public class RoomServlet extends HttpServlet {
    private DatPhongServiceImpl datPhongService = new DatPhongServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action= "";
        }
        switch (action){
            case "create" :
                showCreate(request,response);
                break;
            case "list":
                showList(request,response);
                break;
//            case "listchitiet":
//                showlistChiTiet(request,response);

            default:
                showList(request,response);
                break;
        }

    }

//    private void showlistChiTiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        List<DatPhong> datPhongList = datPhongService.findAllChiTiet();
//        request.setAttribute("listRoom", datPhongList);
//        request.getRequestDispatcher("/room/listchitiet.jsp").forward(request,response);
//    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/room/create.jsp");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DatPhong> datPhongList = datPhongService.findAll();
        System.out.println(datPhongList.size());
        request.setAttribute("listRoom", datPhongList);
        request.getRequestDispatcher("/room/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                create(request,response);
                break;
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maDatPhong = Integer.parseInt(request.getParameter("maDatPhong"));
        int maPhong = Integer.parseInt(request.getParameter("maPhong"));
        String tenKhachHang = request.getParameter("name");
        Date ngayDat = Date.valueOf(request.getParameter("ngayDat"));
        double tienDatCoc = Double.parseDouble(request.getParameter("tienCoc"));
        String trangThaiDat  = request.getParameter("trangThai");
        DatPhong datPhong = new DatPhong(maDatPhong,maPhong,tenKhachHang,ngayDat,tienDatCoc,trangThaiDat);
        datPhongService.add(datPhong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room/create.jsp");
        showList(request,response);
    }
}

package com.example.on_tap.controller;

import com.example.on_tap.model.Category;
import com.example.on_tap.model.Product;
import com.example.on_tap.repository.ProductRepositoryImpl;
import com.example.on_tap.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService = new ProductServiceImpl();
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
                showListProduct(request,response);
                break;
            case "sort":
                goSort(request,response);
                break;
            default:
                showListProduct(request,response);
                break;
        }
    }

    private void goSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.sort();
        System.out.println(productList.size());
        request.setAttribute("listProduct", productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product =productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product/update.jsp").forward(request,response);
    }

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> productList = productService.search(name);
        request.setAttribute("listProduct", productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("/product/create.jsp");
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        System.out.println(productList.size());
        request.setAttribute("listProduct", productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);
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

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double gia = Double.parseDouble(request.getParameter("price"));
        int soLuong = Integer.parseInt(request.getParameter("soluong"));
        String color = request.getParameter("color");
        Date day = Date.valueOf(request.getParameter("day"));
        String moTa = request.getParameter("des");
        String tenDanhMuc = request.getParameter("category");
        Product product = new Product(id,name,gia,soLuong,color,day,moTa,tenDanhMuc);
        productService.update(product);
        response.sendRedirect("/product");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        productService.deleteProduct(id);
        showListProduct(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double gia = Double.parseDouble(request.getParameter("price"));
        int soLuong = Integer.parseInt(request.getParameter("soluong"));
        String color = request.getParameter("color");
        Date day = Date.valueOf(request.getParameter("day"));
        String moTa = request.getParameter("des");
        String tenDanhMuc = request.getParameter("category");
        Product product = new Product(name,gia,soLuong,color,day,moTa,tenDanhMuc);
        productService.add(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        showListProduct(request,response);
    }
}

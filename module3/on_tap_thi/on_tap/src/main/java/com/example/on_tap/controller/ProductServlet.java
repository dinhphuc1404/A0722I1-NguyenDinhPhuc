package com.example.on_tap.controller;

import com.example.on_tap.model.Category;
import com.example.on_tap.model.Product;
import com.example.on_tap.repository.ProductRepositoryImpl;
import com.example.on_tap.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
            default:
                showListProduct(request,response);
                break;

        }
    }

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> productList = productService.search(name);
        request.setAttribute("listProduct", productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        List<Category> category = ProductRepositoryImpl.findAllCategory();
//        request.setAttribute("listCategory", category);
        response.sendRedirect("/product/create.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
//        dispatcher.forward(request,response);
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
               // update(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
        }
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
        String moTa = request.getParameter("des");
        String tenDanhMuc = request.getParameter("category");
        Product product = new Product(name,gia,soLuong,color,moTa,tenDanhMuc);
        productService.add(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        showListProduct(request,response);

    }
}

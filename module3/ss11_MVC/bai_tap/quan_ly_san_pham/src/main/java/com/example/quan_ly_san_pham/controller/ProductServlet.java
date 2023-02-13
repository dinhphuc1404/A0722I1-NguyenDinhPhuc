package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.ProductServiceImpl;

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
            action="";
        }
        switch (action){
            case "add":
            break;
            case "update":
                break;
            case "delete":
                break;
            default:
                showProduct(request,response);
                break;
        }
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.showAll();
        System.out.println(productList.size());
        request.setAttribute("listProduct", productList);
        request.getRequestDispatcher("product/list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

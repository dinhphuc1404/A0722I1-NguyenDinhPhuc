package Controller;

import Model.Category;
import Model.Product;
import Repository.ProductRepository;
import Service.CategoryService;
import Service.CategoryServiceImpl;
import Service.ProductService;
import Service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                save(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
//            case "search":
//                searchProduct(request,response);
//                break;
            case "update":
                updateProduct(request, response);
                break;
            default:
                getProductList(request, response);
                break;
        }


    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String color = request.getParameter("color");
        String des = request.getParameter("des");
        int id_cate = Integer.parseInt(request.getParameter("category"));

        Product product = new Product(id, name, price, soluong, color, des, id_cate);
        productService.updateProductId(product);

        request.setAttribute("mess", "Update thanh cong");
        getProductList(request, response);


    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        boolean check = productService.deleteProduct(id);
        String mess = "Xoa  thanh cong";
        if (check) {
            mess = "Xoa khong thanh cong";
        }
        request.setAttribute("mess", mess);
        getProductList(request, response);

    }

    //
    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = productService.getIdMax() + 1;
        System.out.println(id);
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String color = request.getParameter("color");
        String des = request.getParameter("des");
        int id_cate = Integer.parseInt(request.getParameter("category"));

        Product product = new Product(id, name, price, soluong, color, des, id_cate);
        productService.save(product);
//        if (mess.isEmpty()){
//            request.setAttribute("mess","Them moi thanh cong");
//        }else {
//            request.setAttribute("mess","Them moi that bai");
//
//        }


        getProductList(request, response);


    }

//}


    private void getProductList(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("listp",productService.getProductList());
//        try {
//            request.getRequestDispatcher("/product.jsp").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        List<Product> productList = productService.getProductList();
        List<Category> categoryList = categoryService.getListCategory();

        request.setAttribute("listp", productList);
        request.setAttribute("listc", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                goUpdate(request, response);
                break;
            case "create":
                showFormCreate(request, response);
                break;
            case "search":
                search(request, response);
                break;

            default:
                getProductList(request, response);
                break;
        }


    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String color = request.getParameter("color");

        List<Product> productList = productService.search(name, color);
        List<Category> categoryList = categoryService.getListCategory();
        request.setAttribute("listp", productList);
        request.setAttribute("listc", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        List<Product> productList=productService.getProductList();
//        List<Category> categoryList=categoryService.getListCategory();
//
//        request.setAttribute("listp",productList);
//        request.setAttribute("listc",categoryList);
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("product", productService.getProductId(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productEdit.jsp");
        dispatcher.forward(request, response);


    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productAdd.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

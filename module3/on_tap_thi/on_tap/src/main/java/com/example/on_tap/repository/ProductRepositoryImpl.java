package com.example.on_tap.repository;

import com.example.on_tap.model.Category;
import com.example.on_tap.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository{
    private static final String SELECT_ALL_PRODUCT = "select san_pham.id, san_pham.name, san_pham.gia, san_pham.so_luong, san_pham.color, san_pham.mo_ta, danh_muc.ten_danh_muc from san_pham join\n" +
            "danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc;";
    private static final String INSERT_SANPHAM_PRODUCT = "INSERT INTO san_pham" + " (name,gia,so_luong,color,mo_ta,id_danh_muc)VALUES"+" (?, ?, ?,?, ?, ?);";
    private static final String SELECT_DANHMUC= "select * from danh_muc;";
    private static final String DELETE_SANPHAM= "delete from san_pham where id=?;";
    private static final String SELECT_SANPHAM_BY_NAME = "select san_pham.id,san_pham.name,san_pham.gia,san_pham.so_luong,san_pham.color,san_pham.mo_ta,danh_muc.ten_danh_muc \n" +
            "from san_pham join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc where name like ?;";
    DBConnection connection = new DBConnection();
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        if(connection!=null){
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_ALL_PRODUCT);){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id =resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double gia = resultSet.getDouble("gia");
                    int soLuong = resultSet.getInt("so_luong");
                    String color = resultSet.getString("color");
                    String moTa = resultSet.getString("mo_ta");
                    String tenDanhMuc = resultSet.getString("ten_danh_muc");
                    Product product = new Product(id,name,gia,soLuong,color,moTa,tenDanhMuc);
                    productList.add(product);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return productList;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(DELETE_SANPHAM);
            ps.setInt(1, id);
            rowDelete =  ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }


    @Override
    public void add(Product product) {
        System.out.println(INSERT_SANPHAM_PRODUCT);
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SANPHAM_PRODUCT)) {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getGia());
            preparedStatement.setInt(3,product.getSoLuong());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getMoTa());
            preparedStatement.setString(6,product.getTenDanhMuc());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product findById(int id) {
        Product product = new Product();

        return product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SANPHAM_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("name");
                double gia = rs.getDouble("gia");
                int soLuong = rs.getInt("so_luong");
                String color = rs.getString("color");
                String moTa = rs.getString("mo_ta");
                String tenDanhMuc= rs.getString("ten_danh_muc");
                productList.add(new Product(id, name, gia, soLuong, color, moTa, tenDanhMuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

//    public static List<Category> findAllCategory() {
//        List<Category> categories = new ArrayList<>();
//        Connection connection = DBConnection.getConnection();
//        if(connection!=null){
//            try {
//                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DANHMUC);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()){
//                    int id_danh_muc =resultSet.getInt("id_danh_muc");
//                    String ten_danh_muc = resultSet.getString("ten_danh_muc");
//                    Category category = new Category(id_danh_muc,ten_danh_muc);
//                    categories.add(category);
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return categories;

}

package com.example.productti.repository.impl;

import com.example.productti.model.Product;
import com.example.productti.repository.DBConnection;
import com.example.productti.repository.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_PRODUCT = "select p.id, p.name, p.day, c.name_category from product p join category c on p.category_id = c.id_category;";
    private static final String ADD_PRODUCT = "insert into product(name, day, category_id) values (?, ?, ?)";
    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_PRODUCT)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Date day = resultSet.getDate("day");
                    String nameCategory = resultSet.getString("name_category");
                    Product product = new Product(id, name, day, nameCategory);
                    products.add(product);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public void addProduct(Product product) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDate(2, product.getDay());
            preparedStatement.setDouble(3, product.getIdCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

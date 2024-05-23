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
    private static final String SELECT_FINDBYID = "select * from product where id = ?";
    private static final String UPDATE_PRODUCT = "update product set name = ?, day = ?, category_id = ? where id = ?";

    private static final String SEARCH = "select * from product where category_id = ?";
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

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Date day = rs.getDate("day");
                int categoryId = rs.getInt("category_id");
                product = new Product(id, name, day, categoryId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setDate(2, product.getDay());
            statement.setInt(3, product.getIdCategory());
            statement.setInt(4, product.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> search(int category) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH)) {
            preparedStatement.setInt(1,  category);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date day = rs.getDate("day");
                category = rs.getInt("category_id");
                Product product = new Product(id, name, day, category);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}

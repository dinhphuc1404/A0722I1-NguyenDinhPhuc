package com.example.quan_ly_dien_thoai.repository;

import com.example.quan_ly_dien_thoai.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository{
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_CATEGORY= "select * from danh_muc";
    @Override
    public List<Category> findAllCategory() {
        List<Category> categories = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_CATEGORY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idDanhMuc = resultSet.getInt("id_danh_muc");
                    String tenDanhMuc = resultSet.getString("ten_danh_muc");
                    Category category = new Category(idDanhMuc, tenDanhMuc);
                    categories.add(category);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return categories;
    }
}

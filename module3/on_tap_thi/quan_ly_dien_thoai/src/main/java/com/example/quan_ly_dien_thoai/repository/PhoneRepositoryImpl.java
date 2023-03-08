package com.example.quan_ly_dien_thoai.repository;

import com.example.quan_ly_dien_thoai.model.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepositoryImpl implements IPhoneRepository{
    DBConnection dbConnection = new DBConnection();
    private static final String SELECT_ALL_Phone = "select phone.id, phone.name, phone.price, danh_muc.ten_danh_muc  from phone  " +
            "join danh_muc on phone.id_danh_muc = danh_muc.id_danh_muc ;";
    private static final String INSERT_PHONE_SQL = "INSERT INTO phone" + " (name,price,id_danh_muc)VALUES"+" (?, ?, ?);";
    private static final String SELECT_PHONE_BY_ID = "select phone.id, phone.name, phone.price, danh_muc.ten_danh_muc from phone join danh_muc on phone.id_danh_muc = danh_muc.id_danh_muc where phone.id=?; ";
    private static final String DELETE_PHONE_SQL = "delete from phone where id=?;";
    private static final String UPDATE_PHONE_SQL = "update phone set name = ?, price = ?, id_danh_muc = ? where id = ?;";
//private static final String UPDATE_PHONE_SQL = "update phone join danh_muc on phone.id_danh_muc = danh_muc.id_danh_muc\n"+
//        "set phone.name = ?,\n "+
//        "set phone.price= ?,\n"+
//        "set danh_muc.ten_danh_muc = ?,\n where id = ?;";
    @Override
    public List<Phone> findAll() {
        List<Phone> phoneList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Phone);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    String ten_danh_muc = resultSet.getString("ten_danh_muc");
                    Phone phone = new Phone(id,name,price,ten_danh_muc);
                    phoneList.add(phone);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return phoneList;
    }

    @Override
    public Phone findById(int id) {
        Phone phone = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =connection.prepareStatement(SELECT_PHONE_BY_ID)){
            statement.setInt(1,id);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String ten_danh_muc = rs.getString("ten_danh_muc");
                phone = new Phone(id,name,price,ten_danh_muc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phone;
    }

    @Override
    public void addNewPhone(Phone phone) {
        System.out.println(INSERT_PHONE_SQL);
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONE_SQL)){
            preparedStatement.setString(1,phone.getName());
            preparedStatement.setDouble(2,phone.getPrice());
            preparedStatement.setInt(3,phone.getId_danh_muc());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updatePhone(Phone phone) {
        boolean row = false;
        try {
            PreparedStatement statement = this.dbConnection.getConnection().prepareStatement(UPDATE_PHONE_SQL);
            statement.setString(1,phone.getName());
            statement.setDouble(2,phone.getPrice());
            statement.setInt(3,phone.getId_danh_muc());
            statement.setInt(4,phone.getId());
             row = statement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

    @Override
    public boolean deletePhone(int id) {
        boolean row = false;
        try {
        PreparedStatement statement =this.dbConnection.getConnection().prepareStatement(DELETE_PHONE_SQL);
        statement.setInt(1,id);
        row = statement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return row;
    }
}

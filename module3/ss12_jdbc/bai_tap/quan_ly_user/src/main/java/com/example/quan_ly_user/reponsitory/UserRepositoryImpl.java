package com.example.quan_ly_user.reponsitory;

import com.example.quan_ly_user.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository{
    private DBConnection baseRepositories = new DBConnection();
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name,email,country)VALUES"+" (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id = ?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id=?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";
    private static final String SELECT_ALL_USERS_SORT = "select * from users order by name";
    public List<User> sort(){
        List<User> users = new ArrayList<>();
       try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SORT)){
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String email = rs.getString("email");
               String country = rs.getString("country");
               users.add(new User(id,name,email,country));
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
        return users;
    }
    @Override
    public void addNewUser(User user) {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id,name,email,country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement statement = this.baseRepositories.getConnection().prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = this.baseRepositories.getConnection().prepareStatement(UPDATE_USERS_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdate;
    }
}

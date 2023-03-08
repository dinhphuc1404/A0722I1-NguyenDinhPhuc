package com.example.quan_ly_thue_phong_tro.repository;

import com.example.quan_ly_thue_phong_tro.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements IRomRepository{
    DBConnection connection = new DBConnection();
    private static final String SELECT_ALL_ROOM = "select room.id,room.name,room.phone, room.day, pay.ten_thanh_toan from room " +
            "join pay on room.id_thanh_toan = pay.id_thanh_toan;";
    private static final String INSERT_ROOM = "INSERT INTO room" + " (name,phone,day,id_thanh_toan)VALUES"+" (?, ?, ?,?);";
    private static final String SELECT_FINDBYID = "select room.id,room.name,room.phone, room.day, pay.ten_thanh_toan from room join pay on room.id_thanh_toan = pay.id_thanh_toan" +
            " where id = ?;";
    private static final String UPDATE_ROOM = "update room set name = ? , phone  = ?  , day = ? , id_thanh_toan = ? where id = ?;";
    private static final String DELETE_ROOM= "delete from room where id=?;";
    private static final String SEARCH = "select room.id,room.name,room.phone, room.day, pay.ten_thanh_toan from room \n" +
            "           join pay on room.id_thanh_toan = pay.id_thanh_toan   where name like ? ;";
    @Override
    public List<Room> findAll() {
        List<Room> roomList = new ArrayList<>();
        if (connection!=null){
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_ALL_ROOM)){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    Date day = resultSet.getDate("day");
                    String tenThanhToan = resultSet.getString("ten_thanh_toan");
                    Room room = new Room(id,name,phone,day,tenThanhToan);
                    roomList.add(room);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return roomList;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(DELETE_ROOM);
            ps.setInt(1, id);
            rowDelete =  ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public void add(Room room) {
        System.out.println(INSERT_ROOM);
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM)){
                preparedStatement.setString(1,room.getName());
                preparedStatement.setString(2,room.getPhone());
                preparedStatement.setDate(3,room.getDay());
                preparedStatement.setString(4,room.getTenThanhToan());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean update(Room room) {
        boolean row = false;
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE_ROOM);
            statement.setString(1,room.getName());
            statement.setString(2,room.getPhone());
            statement.setDate(3,room.getDay());
            statement.setString(4,room.getTenThanhToan());
            statement.setInt(5,room.getId());
            row = statement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

    @Override
    public Room findById(int id) {
        Room room = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                Date day = rs.getDate("day");
                String tenThanhToan = rs.getString("ten_thanh_toan");
                room = new Room(id,name,phone,day,tenThanhToan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return room;
    }

    @Override
    public List<Room> search(String name) {
        List<Room> roomList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH)){
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                 name = rs.getString("name");
                String phone = rs.getString("phone");
                Date day = rs.getDate("day");
                String tenThanhToan = rs.getString("ten_thanh_toan");
                Room room = new Room(id,name,phone,day,tenThanhToan);
                roomList.add(room);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }
}

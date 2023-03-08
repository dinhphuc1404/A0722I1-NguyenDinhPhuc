package com.example.thi.repository;

import com.example.thi.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements IRoomRepository{
    DBConnection connection = new DBConnection();
    private static final String SELECT_ALL = "select * from mat_bang;";
    private static final String INSERT_ROOM = "INSERT INTO mat_bang" + " " +
            "(ma_mat_bang,trang_thai,dien_tich,tang,loai_mat_bang,gia_tien,mo_ta,ngay_bat_dau,ngay_ket_thuc)VALUES"+" (?, ?, ?,?, ?, ?,?, ?,?);";
    private static final String DELETE= "delete from mat_bang where id=?;";
    private static final String SORT = "select * from mat_bang order by dien_tich;";
    private static final String SEARCH = "select * from mat_bang where loai_mat_bang like ?;";
    private static final String SEARCH_TANG = "select * from mat_bang where tang like ?;";
    private static final String SEARCH_GIA = " select * from mat_bang where gia_tien like ?;";
    @Override
    public List<Room> findAll() {
        List<Room> roomList = new ArrayList<>();
        if(connection!=null){
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_ALL)){
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    int id =rs.getInt("id");
                    String maMatBang = rs.getString("ma_mat_bang");
                    String trangThai = rs.getString("trang_thai");
                    double dienTich = rs.getDouble("dien_tich");
                    int tang = rs.getInt("tang");
                    String loaiMatBang = rs.getString("loai_mat_bang");
                    double giaTien = rs.getDouble("gia_tien");
                    String moTa = rs.getString("mo_ta");
                    Date ngayBatDau = rs.getDate("ngay_bat_dau");
                    Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                    Room room = new Room(id,maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,moTa,ngayBatDau,ngayKetThuc);
                    roomList.add(room);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return roomList;
    }

    @Override
    public void add(Room room) {
        System.out.println(INSERT_ROOM);
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM)){
            preparedStatement.setString(1,room.getMaMatBang());
            preparedStatement.setString(2,room.getTrangThai());
            preparedStatement.setDouble(3,room.getDienTich());
            preparedStatement.setInt(4,room.getTang());
            preparedStatement.setString(5,room.getLoaiMatBang());
            preparedStatement.setDouble(6,room.getGiaTien());
            preparedStatement.setString(7,room.getMoTa());
            preparedStatement.setDate(8,room.getNgayBatDau());
            preparedStatement.setDate(9,room.getNgayKetThuc());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(DELETE);
            ps.setInt(1, id);
            rowDelete =  ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Room> searchLoaiMatBang(String loaiMatBang) {
    List<Room> roomList = new ArrayList<>();
    try (Connection connection = DBConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SEARCH)){
        preparedStatement.setString(1, "%" + loaiMatBang + "%");
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int id =rs.getInt("id");
            String maMatBang = rs.getString("ma_mat_bang");
            String trangThai = rs.getString("trang_thai");
            double dienTich = rs.getDouble("dien_tich");
            int tang = rs.getInt("tang");
            loaiMatBang = rs.getString("loai_mat_bang");
            double giaTien = rs.getDouble("gia_tien");
            String moTa = rs.getString("mo_ta");
            Date ngayBatDau = rs.getDate("ngay_bat_dau");
            Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
            Room room = new Room(id,maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,moTa,ngayBatDau,ngayKetThuc);
            roomList.add(room);
        }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
        return roomList;
    }

    @Override
    public List<Room> searchTang(int tang) {
        List<Room> roomList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_TANG)){
            preparedStatement.setInt(1,  tang );
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                double dienTich = rs.getDouble("dien_tich");
                 tang = rs.getInt("tang");
               String loaiMatBang = rs.getString("loai_mat_bang");
                double giaTien = rs.getDouble("gia_tien");
                String moTa = rs.getString("mo_ta");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                Room room = new Room(id,maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,moTa,ngayBatDau,ngayKetThuc);
                roomList.add(room);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }

    @Override
    public List<Room> searchGia(double giaTien) {
        List<Room> roomList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_GIA)){
            preparedStatement.setDouble(1,  giaTien );
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                double dienTich = rs.getDouble("dien_tich");
                int  tang = rs.getInt("tang");
                String loaiMatBang = rs.getString("loai_mat_bang");
                 giaTien = rs.getDouble("gia_tien");
                String moTa = rs.getString("mo_ta");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                Room room = new Room(id,maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,moTa,ngayBatDau,ngayKetThuc);
                roomList.add(room);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }

    @Override
    public List<Room> sort() {
        List<Room> roomList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                double dienTich = rs.getDouble("dien_tich");
                int tang = rs.getInt("tang");
                String loaiMatBang = rs.getString("loai_mat_bang");
                double giaTien = rs.getDouble("gia_tien");
                String moTa = rs.getString("mo_ta");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                Room room = new Room(id,maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,moTa,ngayBatDau,ngayKetThuc);
                roomList.add(room);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }
}

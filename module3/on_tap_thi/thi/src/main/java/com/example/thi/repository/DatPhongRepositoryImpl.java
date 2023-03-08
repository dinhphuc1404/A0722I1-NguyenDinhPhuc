package com.example.thi.repository;

import com.example.thi.model.DatPhong;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatPhongRepositoryImpl implements DatPhongRepository{
    DBConnection connection = new DBConnection();
    private static final String SELECT_ALL_LICHSUDATPHONG = "select dat_phong.id, dat_phong.ma_dat_phong, dat_phong.ma_phong, khach_hang.ten_kh, dat_phong.ngay_dat, dat_phong.tien_dat_coc, dat_phong.trang_thai_dat\n" +
            "from dat_phong join khach_hang on dat_phong.ma_kh = khach_hang.ma_kh;";
    private static final String INSERT = "INSERT INTO dat_phong" + " (ma_dat_phong,ma_phong,ma_kh,ngay_dat,tien_dat_coc,trang_thai_dat)VALUES"+" (?, ?, ?,?, ?, ?);";
    private static final String SELECT_CHITIET = "select dat_phong.id, dat_phong.ma_dat_phong, dat_phong.ma_phong, khach_hang.ten_kh, dat_phong.ngay_dat, dat_phong.tien_dat_coc, dat_phong.trang_thai_dat\n" +
            "from dat_phong join khach_hang on dat_phong.ma_kh = khach_hang.ma_kh where id = ?;";
    @Override
    public List<DatPhong> findAll() {
        List<DatPhong> datPhongList = new ArrayList<>();
        if(connection!=null){
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_ALL_LICHSUDATPHONG);){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int maDatPhong = resultSet.getInt("ma_dat_phong");
                    int maPhong = resultSet.getInt("ma_phong");
                    String tenKhachHang = resultSet.getString("ten_kh");
                    Date ngayDat = resultSet.getDate("ngay_dat");
                    double tienDatCoc = resultSet.getDouble("tien_dat_coc");
                    String trangThaiDat = resultSet.getString("trang_thai_dat");
                    DatPhong datPhong = new DatPhong(id,maDatPhong,maPhong,tenKhachHang,ngayDat,tienDatCoc,trangThaiDat);
                    datPhongList.add(datPhong);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return datPhongList;
    }

    @Override
    public void add(DatPhong datPhong) {
        System.out.println(INSERT);
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(INSERT);){
            preparedStatement.setInt(1,datPhong.getMaDatPhong());
            preparedStatement.setInt(2,datPhong.getMaPhong());
            preparedStatement.setString(3,datPhong.getTenKhachHang());
            preparedStatement.setDate(4,datPhong.getNgayDat());
            preparedStatement.setDouble(5,datPhong.getTienDatCoc());
            preparedStatement.setString(6,datPhong.getTrangThaiDat());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<DatPhong> findAllChiTiet() {
        List<DatPhong> datPhongList = new ArrayList<>();
        if(connection!=null){
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SELECT_CHITIET);){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int maDatPhong = resultSet.getInt("ma_dat_phong");
                    int maPhong = resultSet.getInt("ma_phong");
                    String tenKhachHang = resultSet.getString("ten_kh");
                    Date ngayDat = resultSet.getDate("ngay_dat");
                    double tienDatCoc = resultSet.getDouble("tien_dat_coc");
                    String trangThaiDat = resultSet.getString("trang_thai_dat");
                    DatPhong datPhong = new DatPhong(id,maDatPhong,maPhong,tenKhachHang,ngayDat,tienDatCoc,trangThaiDat);
                    datPhongList.add(datPhong);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return datPhongList;
    }

}

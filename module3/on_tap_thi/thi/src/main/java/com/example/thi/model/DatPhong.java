package com.example.thi.model;

import java.sql.Date;
import java.sql.Time;

public class DatPhong {
    private  int id;
    private int maDatPhong;
    private int maPhong;
    private int maKhachHang;
    private String tenKhachHang;
    private Date ngayDat;
    private Time gioBatDau;
    private Time gioKetThuc;
    private double tienDatCoc;
    private String ghiChu;
    private String trangThaiDat;


    public DatPhong() {
    }

    public DatPhong(int id, int maDatPhong, int maPhong, int maKhachHang, String tenKhachHang, Date ngayDat, Time gioBatDau, Time gioKetThuc, double tienDatCoc, String ghiChu, String trangThaiDat) {
        this.id = id;
        this.maDatPhong = maDatPhong;
        this.maPhong = maPhong;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngayDat = ngayDat;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.tienDatCoc = tienDatCoc;
        this.ghiChu = ghiChu;
        this.trangThaiDat = trangThaiDat;
    }

    public DatPhong(int maDatPhong, int maPhong, int maKhachHang, Date ngayDat, Time gioBatDau, Time gioKetThuc, double tienDatCoc, String ghiChu, String trangThaiDat) {
        this.maDatPhong = maDatPhong;
        this.maPhong = maPhong;
        this.maKhachHang = maKhachHang;
        this.ngayDat = ngayDat;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.tienDatCoc = tienDatCoc;
        this.ghiChu = ghiChu;
        this.trangThaiDat = trangThaiDat;
    }

    public DatPhong(int id, int maDatPhong, int maPhong, String tenKhachHang, Date ngayDat, double tienDatCoc, String trangThaiDat) {
        this.id = id;
        this.maDatPhong = maDatPhong;
        this.maPhong = maPhong;

        this.tenKhachHang = tenKhachHang;
        this.ngayDat = ngayDat;

        this.tienDatCoc = tienDatCoc;

        this.trangThaiDat = trangThaiDat;
    }

    public DatPhong(int maDatPhong, int maPhong, String tenKhachHang, Date ngayDat, double tienDatCoc, String trangThaiDat) {

        this.maDatPhong = maDatPhong;
        this.maPhong = maPhong;

        this.tenKhachHang = tenKhachHang;
        this.ngayDat = ngayDat;

        this.tienDatCoc = tienDatCoc;

        this.trangThaiDat = trangThaiDat;
    }

    public int getMaDatPhong() {
        return maDatPhong;
    }

    public void setMaDatPhong(int maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Time getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThaiDat() {
        return trangThaiDat;
    }

    public void setTrangThaiDat(String trangThaiDat) {
        this.trangThaiDat = trangThaiDat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
}

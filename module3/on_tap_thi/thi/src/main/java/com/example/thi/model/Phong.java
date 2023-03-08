package com.example.thi.model;

public class Phong {
    private int maPhong;
    private String loaiPhong;
    private int soKhachToiDa;
    private double giaPhong;
    private String moTa;

    public Phong() {
    }

    public Phong(int maPhong, String loaiPhong, int soKhachToiDa, double giaPhong, String moTa) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.soKhachToiDa = soKhachToiDa;
        this.giaPhong = giaPhong;
        this.moTa = moTa;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getSoKhachToiDa() {
        return soKhachToiDa;
    }

    public void setSoKhachToiDa(int soKhachToiDa) {
        this.soKhachToiDa = soKhachToiDa;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}

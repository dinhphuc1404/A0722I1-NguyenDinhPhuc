package com.example.on_tap.model;

import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private double gia;
    private int soLuong;
    private String color;
    private Date day;
    private String moTa;
    private int idDanhMuc;
    private String tenDanhMuc;

    public Product() {
    }

    public Product(int id, String name, double gia, int soLuong, String color, Date day, String moTa, int idDanhMuc, String tenDanhMuc) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.day = day;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public Product(int id, String name, double gia, int soLuong, String color, String moTa, int idDanhMuc, String tenDanhMuc) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public Product(int id, String name, double gia, int soLuong, String color, String moTa, String tenDanhMuc) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.tenDanhMuc = tenDanhMuc;
    }

    public Product(String name, Double gia, int soLuong, String color, String moTa, int idDanhMuc) {

        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;

    }

    public Product(String name, Double gia, int soLuong, String color, String moTa, String tenDanhMuc) {
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.tenDanhMuc = tenDanhMuc;
    }

    public Product(int id, String name, double gia, int soLuong, String color, String moTa, int idDanhMuc) {
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
    }

    public Product(int id, String name, double gia, int soLuong, String color, Date day, String moTa, String tenDanhMuc) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.day = day;
        this.moTa = moTa;
        this.tenDanhMuc = tenDanhMuc;
    }

    public Product(String name, Double gia, int soLuong, String color, Date day, String moTa, String tenDanhMuc) {
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.day = day;
        this.moTa = moTa;
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}

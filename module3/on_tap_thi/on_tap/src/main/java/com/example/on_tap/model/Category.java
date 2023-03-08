package com.example.on_tap.model;

public class Category {
    private int id_danh_muc;
    private String ten_danh_muc;


    public Category() {
    }

    public Category(int id_danh_muc, String ten_danh_muc) {
        this.id_danh_muc = id_danh_muc;
        this.ten_danh_muc = ten_danh_muc;
    }

    public int getId_danh_muc() {
        return id_danh_muc;
    }

    public void setId_danh_muc(int id_danh_muc) {
        this.id_danh_muc = id_danh_muc;
    }

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }
}

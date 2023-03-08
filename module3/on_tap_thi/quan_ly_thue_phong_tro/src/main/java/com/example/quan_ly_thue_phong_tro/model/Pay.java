package com.example.quan_ly_thue_phong_tro.model;

public class Pay {
    private  int idThanhToan;
    private String tenThanhToan;

    public Pay() {
    }

    public Pay(int idThanhToan, String tenThanhToan) {
        this.idThanhToan = idThanhToan;
        this.tenThanhToan = tenThanhToan;
    }

    public int getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(int idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getTenThanhToan() {
        return tenThanhToan;
    }

    public void setTenThanhToan(String tenThanhToan) {
        this.tenThanhToan = tenThanhToan;
    }
}

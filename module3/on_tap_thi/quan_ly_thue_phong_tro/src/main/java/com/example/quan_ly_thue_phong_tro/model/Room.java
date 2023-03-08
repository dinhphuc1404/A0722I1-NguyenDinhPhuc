package com.example.quan_ly_thue_phong_tro.model;

import java.sql.Date;

public class Room {
    private int id;
    private String name;
    private String phone;
    private Date day;
    private int idThanhToan;
    private String tenThanhToan;

    public Room() {
    }

    public Room(int id, String name, String phone, Date day, int idThanhToan, String tenThanhToan) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.idThanhToan = idThanhToan;
        this.tenThanhToan = tenThanhToan;
    }

    public Room(int id, String name, String phone, Date day, String tenThanhToan) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.tenThanhToan = tenThanhToan;
    }

    public Room(String name, String phone, Date day, String tenThanhToan) {
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.tenThanhToan = tenThanhToan;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
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

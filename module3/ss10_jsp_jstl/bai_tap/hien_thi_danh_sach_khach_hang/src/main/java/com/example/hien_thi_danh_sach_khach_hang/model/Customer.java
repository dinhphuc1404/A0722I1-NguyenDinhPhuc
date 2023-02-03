package com.example.hien_thi_danh_sach_khach_hang.model;

public class Customer {
    private String name;
    private String dateOfBirth;
    private String addreess;
    private String image;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String addreess, String image) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.addreess = addreess;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddreess() {
        return addreess;
    }

    public void setAddreess(String addreess) {
        this.addreess = addreess;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

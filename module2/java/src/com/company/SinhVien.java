package com.company;

public class SinhVien extends Person{
    private String maSV;
    public SinhVien(String ten, int tuoi) {
        super(ten, tuoi);
    }

    public SinhVien(String ten, int tuoi, String maSV) {
        super(ten, tuoi);
        this.maSV = maSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + this.maSV + '\'' +
                '}';
    }
}

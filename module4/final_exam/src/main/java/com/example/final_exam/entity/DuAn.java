package com.example.final_exam.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class DuAn {
    @Id
    @NotBlank
    private String maDuAn;
    @NotBlank
    private String tenDuAn;

    @ManyToOne
    @JoinColumn(name = "idDoanhNghiep", referencedColumnName = "idDoanhNghiep")
    @NotNull(message = "Không được để trống")
    private DoanhNghiep doanhNghiep;
    @NotNull
    private Double kinhPhi;
    @NotBlank
    private String moTa;
    @NotNull
    private Double thoiGianDangKy;
    @NotNull
    private String ngayDangKy;

    public DuAn() {
    }

    public DuAn(String maDuAn, String tenDuAn, DoanhNghiep doanhNghiep, Double kinhPhi, String moTa, Double thoiGianDangKy, String ngayDangKy) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.doanhNghiep = doanhNghiep;
        this.kinhPhi = kinhPhi;
        this.moTa = moTa;
        this.thoiGianDangKy = thoiGianDangKy;
        this.ngayDangKy = ngayDangKy;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    public Double getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(Double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(Double thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
}

package com.example.final_exam.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DoanhNghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDoanhNghiep;

    private String tenDanhNghiep;
    private String linhVucKinhDoanh;
    private String soDienThoai;
    private String email;
    private String diaChi;
    @OneToMany(mappedBy = "doanhNghiep" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<DuAn> duAns;

    public DoanhNghiep() {
    }

    public DoanhNghiep(Integer idDoanhNghiep, String tenDanhNghiep, String linhVucKinhDoanh, String soDienThoai, String email, String diaChi, Set<DuAn> duAns) {
        this.idDoanhNghiep = idDoanhNghiep;
        this.tenDanhNghiep = tenDanhNghiep;
        this.linhVucKinhDoanh = linhVucKinhDoanh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.duAns = duAns;
    }

    public Integer getIdDoanhNghiep() {
        return idDoanhNghiep;
    }

    public void setIdDoanhNghiep(Integer idDoanhNghiep) {
        this.idDoanhNghiep = idDoanhNghiep;
    }

    public String getTenDanhNghiep() {
        return tenDanhNghiep;
    }

    public void setTenDanhNghiep(String tenDanhNghiep) {
        this.tenDanhNghiep = tenDanhNghiep;
    }

    public String getLinhVucKinhDoanh() {
        return linhVucKinhDoanh;
    }

    public void setLinhVucKinhDoanh(String linhVucKinhDoanh) {
        this.linhVucKinhDoanh = linhVucKinhDoanh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Set<DuAn> getDuAns() {
        return duAns;
    }

    public void setDuAns(Set<DuAn> duAns) {
        this.duAns = duAns;
    }
}

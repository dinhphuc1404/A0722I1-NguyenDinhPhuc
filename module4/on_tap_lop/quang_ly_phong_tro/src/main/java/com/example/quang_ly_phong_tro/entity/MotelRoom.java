package com.example.quang_ly_phong_tro.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;


@Entity
public class MotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Tên không được nhập số và kí tự đặc biệt")
    @Size(min = 5,max = 50, message = "Kí tự đối đa là 50 tối thiểu 5")
    private String name;
    @NotBlank(message = "Số điện thoại không được để trống")
//    @Pattern(regexp = "^(0)[0-9]{9}$",message = "Điện thoại phải có 10 số và bắt đầu bằng số 0.")
    private String phoneNumber;
    private Date firstDay;
    @ManyToOne
    @JoinColumn(name = "payId", referencedColumnName = "payId")
    private Pay payName;
    @Size(min = 0, max = 200, message = "Không nhập quá 200 kí tự")
    private String note;

    public MotelRoom() {
    }

    public MotelRoom(Integer id, String name, String phoneNumber, Date firstDay, Pay payName, String note) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.firstDay = firstDay;
        this.payName = payName;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    public Pay getPayName() {
        return payName;
    }

    public void setPayName(Pay payName) {
        this.payName = payName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

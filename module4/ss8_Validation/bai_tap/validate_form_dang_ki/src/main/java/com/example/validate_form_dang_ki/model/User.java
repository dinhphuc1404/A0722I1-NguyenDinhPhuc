package com.example.validate_form_dang_ki.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    @NotBlank
    @Size(min = 5, max = 45, message = "Vui lòng nhập lớn hơn 5 và nhỏ hơn 45")
    private String name;
    private String phone;

    @Email(message = "Vui lòng nhập đúng định dạng email")
    private String email;

    @Min(value = 18,message = "Vui lòng nhập lớn hơn 18 tuổi")
    private int age;

    public User() {
    }

    public User(@NotBlank @Size(min = 5, max = 45) String name, String phone,@Email String email, @Min(18) int age) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

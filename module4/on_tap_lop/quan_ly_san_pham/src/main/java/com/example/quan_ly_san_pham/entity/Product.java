package com.example.quan_ly_san_pham.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Product {
    @Id
    @Pattern(regexp = "SP-\\d{3}", message = "{create.id}")
    private String id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max=50, message = "Vui lòng nhập nhỏ hơn 50 và lơn hơn 5")
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @NotNull(message = "Không được để trống")
    private Category category;
    @NotNull(message = "Vui lòng nhập giá tiền")
    private Double price;

    private Date date;

    public Product() {
    }

    public Product(String id, String name, Category category, Date date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

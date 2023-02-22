package Model;

import java.util.Objects;

public class Product {
    private int id_product;
    private String name;
    private Double gia;
    private int soLuong;
    private String color;
    private String moTa;
    private int id_category;


    public Product() {
    }

    public Product(int id_product) {
        this.id_product = id_product;
    }

    public Product(int id_product, String name, Double gia, int soLuong, String color, String moTa, int id_category) {
        this.id_product = id_product;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.color = color;
        this.moTa = moTa;
        this.id_category = id_category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", name='" + name + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", color='" + color + '\'' +
                ", moTa='" + moTa + '\'' +
                ", id_category=" + id_category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id_product == product.id_product;
    }


    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}


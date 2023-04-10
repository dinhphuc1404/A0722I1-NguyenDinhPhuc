package com.example.them_san_pham_vao_gio_hang.entity;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Integer idCart;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    private Integer quantity;

    public Cart() {
    }

    public Cart(Integer idCart, Product product, Integer quantity) {
        this.idCart = idCart;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void deleteProduct(){
        quantity--;
    }

    public void addProduct(){
        quantity++;
    }

    public double getPrice() {
        return product.getNewPrice() * quantity;
    }
}

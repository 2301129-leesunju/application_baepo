package com.example.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer price;
    private Integer quantity;
    private String category;
    private Boolean onSale;

    protected Product() {
    }

    public Product(String title, Integer price, Integer quantity, String category, Boolean onSale) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.onSale = onSale;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void update(String title, Integer price, Integer quantity, String category, Boolean onSale){
        this.title=title;
        this.price=price;
        this.category=category;
        this.quantity=quantity;
        this.onSale=onSale;
    }
}
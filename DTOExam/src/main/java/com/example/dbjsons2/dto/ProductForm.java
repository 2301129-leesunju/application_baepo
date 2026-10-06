package com.example.dbjsons2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductForm {
    @NotBlank(message = "상품 이름을 입력하세요.")
    @Size(max = 20, message = "상품 이름은 40자 이내로 작성하세요.")
    private String title;

    @NotNull(message = "가격을 입력하십시오.")
    @Min(value = 0,message = "가격은 1 이상이어야 합니다.")
    private Integer price;

    @NotNull(message = "수량을 입력하시오.")
    @Min(value = 0,message = "수량은 0개 이상이어야합니다.")
    private Integer quantity;

    @NotBlank(message = "카테고리를 선택하시오.")
    private String category;

    @NotBlank(message = "판매 상태를 선택하시오.")
    private String onSale;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOnSale() {
        return onSale;
    }

    public void setOnSale(String onSale) {
        this.onSale = onSale;
    }
}

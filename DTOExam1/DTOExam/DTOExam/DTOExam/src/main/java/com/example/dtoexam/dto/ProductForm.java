package com.example.dtoexam.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductForm {

    @NotBlank(message = "상품명은 필수 입력 항목입니다.")
    private String title;

    @NotNull(message = "가격을 입력해 주세요.")
    @Min(value = 100, message = "가격은 최소 100원 이상이어야 합니다.")
    private Integer price;

    public ProductForm() {

    }
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
}

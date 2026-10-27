package com.example.dtoexam.service;

import com.example.dtoexam.domain.Product;
import com.example.dtoexam.dto.ProductForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long sequence = 1L;

    // 상품 등록
    public void save(ProductForm productForm) {
        Product product = new Product(
                sequence++,
                productForm.getTitle(),
                productForm.getPrice(),
                0,
                "미분류",
                true
        );

        products.add(product);
    }

    // 상품 전체 조회
    public List<Product> findAll() {
        return products;
    }
}
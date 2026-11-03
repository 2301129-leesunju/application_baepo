package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(String title, Integer price, Integer quantity, String category, Boolean onSale) {
        Product product = new Product(
                title,
                price,
                quantity,
                category,
                onSale
        );

        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
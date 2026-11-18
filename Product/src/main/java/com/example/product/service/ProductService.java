package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.domain.Study;
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
    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException(
                                "해당 스터디 신청을 찾을 수 없어요"
                        )
                );

    }
    public Product update(Long id , String title, Integer price, Integer quantity, String category, Boolean onSale){
        Product product = findById(id);
        product.update(title,price,quantity,category,onSale);
        return productRepository.save(product);
    }
    public void delete(Long id){
        findById(id);
        productRepository.deleteById(id);
    }
}
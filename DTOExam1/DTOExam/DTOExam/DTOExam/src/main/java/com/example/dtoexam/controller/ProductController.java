package com.example.dtoexam.controller;

import com.example.dtoexam.dto.ProductForm;
import com.example.dtoexam.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 목록
    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    // 상품 등록 화면
    @GetMapping("/products/new")
    public String showProductForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product-form";
    }

    // 상품 등록 처리
    @PostMapping("/products")
    public String registerProduct(
            @Valid @ModelAttribute("productForm") ProductForm productForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "product-form";
        }

        productService.save(productForm);

        return "redirect:/products";
    }
}
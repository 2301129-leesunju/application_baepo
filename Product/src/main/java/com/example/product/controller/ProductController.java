package com.example.product.controller;

import com.example.product.dto.ProductForm;
import com.example.product.service.ProductService;
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

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/products/new")
    public String showProductForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product-form";
    }

    @PostMapping("/products")
    public String registerProduct(
            @Valid @ModelAttribute("productForm") ProductForm productForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "product-form";
        }

        productService.save(
                productForm.getTitle(),
                productForm.getPrice(),
                productForm.getQuantity(),
                productForm.getCategory(),
                productForm.getOnSale()
        );

        return "redirect:/products";
    }
}
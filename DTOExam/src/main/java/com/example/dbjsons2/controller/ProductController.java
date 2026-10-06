package com.example.dbjsons2.controller;

import com.example.dbjsons2.dto.ProductForm;
import com.example.dbjsons2.dto.StudyForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping("/products/new")
    public String showStudyForm(Model model){
    model.addAttribute("productForm",new ProductForm());
    return "product-form";
}
    @PostMapping("/products")
    public String applyStudy(
            @Valid
            @ModelAttribute("productForm")
            ProductForm productForm, BindingResult bindingResult

    ){
        if (bindingResult.hasErrors()){
            return "product-form";
        }
        return "product-result";
    }
}

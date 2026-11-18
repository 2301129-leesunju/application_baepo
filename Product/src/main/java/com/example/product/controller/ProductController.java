package com.example.product.controller;

import com.example.product.domain.Product;
import com.example.product.domain.Study;
import com.example.product.dto.ProductForm;
import com.example.product.dto.StudyForm;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/product/new")
    public String showProductForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product-form";
    }

    @PostMapping("/product")
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

        return "redirect:/product";
    }
    @GetMapping("/product/{id}")
    public String showProductDetail(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-detail";
    }

    @GetMapping("/product/{id}/edit")
    public String showProductEditForm(@PathVariable Long id,Model model){
        Product product = productService.findById(id);
        ProductForm productForm = new ProductForm();
        productForm.setTitle(product.getTitle());
        productForm.setCategory(product.getCategory());
        productForm.setOnSale(product.getOnSale());
        productForm.setQuantity(product.getQuantity());
        productForm.setPrice(product.getPrice());
        model.addAttribute("productId",id);
        model.addAttribute("productForm",productForm);
        return "product-edit";
    }
    @PostMapping("/product/{id}/edit")
    public String updateProduct(@PathVariable Long id,
                              @Valid @ModelAttribute("productForm") ProductForm productForm,
                              BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("productId",id);
            return "product-edit";
        }
        productService.update(id,productForm.getTitle(),productForm.getPrice(),productForm.getQuantity(),productForm.getCategory(),productForm.getOnSale());

        return "redirect:/product/"+id;
    }
    @PostMapping("/product/{id}/delete")
    public String deleteStudy(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/product";
    }
}
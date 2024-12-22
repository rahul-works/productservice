package com.scalarpractice.productservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.scalarpractice.productservice.model.Product;
import com.scalarpractice.productservice.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public void getAllProducts(){

    }

    @GetMapping("/product/{id}")
    public Product getProductDetails(@PathVariable("id")Long id) {
        return this.productService.getProductDetails(id);
    }

    public void createProduct() {

    }
}

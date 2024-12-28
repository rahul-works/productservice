package com.scalarpractice.productservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.scalarpractice.dto.CreateProductRequestDto;
import com.scalarpractice.productservice.model.Product;
import com.scalarpractice.productservice.service.ProductService;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product getProductDetails(@PathVariable("id")Long id) {
        //throw new Exception();
        return this.productService.getProductDetails(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto) {
        Product product = productService.createProduct(
            requestDto.getTitle(), 
            requestDto.getDescription(), 
            requestDto.getImage(), 
            requestDto.getPrice(), 
            requestDto.getCategory());
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatusCode.valueOf(201));
        return responseEntity;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

}

// 1xx : Information based response 
// 2xx : working 200 - success, 201 - created
// 3xx : redirects 
// 4xx : something wrong with the client 404 
// 5xx : something wrong on server side 500

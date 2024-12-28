package com.scalarpractice.productservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scalarpractice.productservice.model.Product;

@Service
public interface ProductService {
    public Product getProductDetails(Long id);
    public Product createProduct(String title, 
    String Description, 
    String image, 
    String price, 
    String Category);
    public List<Product> getAllProducts();
}

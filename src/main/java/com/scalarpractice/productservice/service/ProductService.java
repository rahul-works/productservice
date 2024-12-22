package com.scalarpractice.productservice.service;

import org.springframework.stereotype.Service;

import com.scalarpractice.productservice.model.Product;

@Service
public interface ProductService {
    public Product getProductDetails(Long id);
}

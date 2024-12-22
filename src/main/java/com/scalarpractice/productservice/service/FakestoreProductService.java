package com.scalarpractice.productservice.service;

import org.springframework.web.client.RestTemplate;

import com.scalarpractice.productservice.model.Product;

public class FakestoreProductService implements ProductService {
 
    private RestTemplate restTemplate;

    public FakestoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id) {
        this.restTemplate.getForObject(null, null);
        return null;
    }
}

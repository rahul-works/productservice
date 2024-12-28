package com.scalarpractice.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CategoryController {

    @GetMapping("/category/{id}")
    public void getCategoryDetails(@PathVariable("id")Long id) {
        //throw new Exception();
        // return this.productService.getProductDetails(id);
    }
}

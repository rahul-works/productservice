package com.scalarpractice.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.scalarpractice.dto.CreateProductRequestDto;
import com.scalarpractice.dto.FakeStoreCreateProductDto;
import com.scalarpractice.dto.FakeStoreProductDto;
import com.scalarpractice.productservice.model.Category;
import com.scalarpractice.productservice.model.Product;

@Component
public class FakestoreProductService implements ProductService {
 
    private RestTemplate restTemplate;

    public FakestoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
 
    @Override
    public Product getProductDetails(Long id) {
        // FakeStoreProductDto responseDto =
        //     restTemplate.getForObject(
        //         "https://fakestoreapi.com/products/" + id, 
        //         FakeStoreProductDto.class
        //     );
        
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate
        .getForEntity("https://fakestoreapi.com/products/" + id, 
        FakeStoreProductDto.class);

        if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(404)) {
            // show some error
        } else if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(500)) {
            // server issue msg
        }
        return responseEntity.getBody().toProduct();
    }

    @Override
    public Product createProduct(String title, 
    String description, 
    String image, 
    String price, 
    String category) {
        FakeStoreCreateProductDto requestDto = new FakeStoreCreateProductDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setImage(image);
        requestDto.setPrice(price);
        requestDto.setCategory(category);

        FakeStoreProductDto responseDto = restTemplate.postForObject("https://fakestoreapi.com/products", 
        requestDto, 
        FakeStoreProductDto.class);
        return responseDto.toProduct();   
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] responseDto = restTemplate.getForObject( 
            "https://fakestoreapi.com/products/", 
             FakeStoreProductDto[].class); // Run time 
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto dto: responseDto) {
            products.add(dto.toProduct());
        }
        return products;
    }
}

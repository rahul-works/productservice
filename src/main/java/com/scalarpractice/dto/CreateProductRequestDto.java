package com.scalarpractice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private Long id;
     private String title;
     private String price;
     private String category;
     private String description;
     private String image;
}


package com.ecommerceProject.Ecommerce.project.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private double price;
    private String description;
    private UUID category;
    private String imageURL;
    private double rating;
}

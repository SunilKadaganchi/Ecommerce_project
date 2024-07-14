package com.ecommerceProject.Ecommerce.project.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {
    private UUID id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}

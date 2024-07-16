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
    /**
     * Don't send the category ID variable in the request Body ,while calling update Product API
     * as we are not allowing to update the category ID
     */
    private UUID category;
    private String imageURL;
    private double rating;
}

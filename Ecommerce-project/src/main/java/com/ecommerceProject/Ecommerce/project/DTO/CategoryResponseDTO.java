package com.ecommerceProject.Ecommerce.project.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO {
    private UUID categoryId;
    private String categoryName;
}

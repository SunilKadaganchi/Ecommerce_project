package com.ecommerceProject.Ecommerce.project.mapper;

import com.ecommerceProject.Ecommerce.project.DTO.ProductRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.ProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.model.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertEntityToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setTitle(product.getTitle());
       // productResponseDTO.setCategory(product.getCategory().getName());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setImageURL(product.getImageURL());

        return productResponseDTO;
    }


    public static Product createUpdateProductRequestDTOToEntity(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setRating(productRequestDTO.getRating());
        product.setImageURL(productRequestDTO.getImageURL());

        return product;
    }
}

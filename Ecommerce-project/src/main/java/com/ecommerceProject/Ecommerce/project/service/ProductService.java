package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.ProductRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.ProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<ProductResponseDTO> getAllProducts();
    public ProductResponseDTO getProductById(UUID id);
    public ProductResponseDTO createProduct(ProductRequestDTO product);
    public ProductResponseDTO updateProduct(UUID productId, ProductRequestDTO product);
    public boolean deleteProduct(UUID ProductId);
}

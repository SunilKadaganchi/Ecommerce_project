package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(UUID id);
    public Product createProduct(Product product);
    public Product updateProduct(UUID productId, Product product);
    public boolean deleteProduct(UUID ProductId);
}

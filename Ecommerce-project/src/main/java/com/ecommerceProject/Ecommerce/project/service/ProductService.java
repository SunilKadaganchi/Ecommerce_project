package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public List<FakeProductResponseDTO> getAllProducts();
    public FakeProductResponseDTO getProductById(int id);
    public Product createProduct(Product product);
}

package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public List<FakeProductResponseDTO> getAllProducts();
}

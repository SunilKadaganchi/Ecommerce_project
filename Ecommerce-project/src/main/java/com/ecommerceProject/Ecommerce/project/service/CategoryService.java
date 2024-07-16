package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.CategoryRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.CategoryResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public List<CategoryResponseDTO> getAllCategories();
    public CategoryResponseDTO getCategoryById(UUID categoryId);
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
    public CategoryResponseDTO updateCategory(CategoryRequestDTO categoryRequestDTO,UUID categoryId);
    public boolean deleteCategory(UUID categoryId);
    public long getTotalPriceForCategory(UUID categoryId);
}

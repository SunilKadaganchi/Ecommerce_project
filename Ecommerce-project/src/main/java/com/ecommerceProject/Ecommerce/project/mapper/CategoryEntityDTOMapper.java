package com.ecommerceProject.Ecommerce.project.mapper;

import com.ecommerceProject.Ecommerce.project.DTO.CategoryRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.CategoryResponseDTO;
import com.ecommerceProject.Ecommerce.project.model.Category;

public class CategoryEntityDTOMapper {
    public  static CategoryResponseDTO convertEntityToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryId(category.getId());
        categoryResponseDTO.setCategoryName(category.getName());

        return categoryResponseDTO;
    }

    public static Category createUpdateCategoryRequestToEntity(CategoryRequestDTO categoryRequestDTO){
        Category category = new Category();
        category.setName(categoryRequestDTO.getName());
        return category;
    }
}

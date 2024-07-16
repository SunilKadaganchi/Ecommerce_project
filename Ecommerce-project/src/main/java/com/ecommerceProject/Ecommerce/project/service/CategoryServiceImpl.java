package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.CategoryRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.CategoryResponseDTO;
import com.ecommerceProject.Ecommerce.project.Exception.CategoryNotFoundException;
import com.ecommerceProject.Ecommerce.project.mapper.CategoryEntityDTOMapper;
import com.ecommerceProject.Ecommerce.project.model.Category;
import com.ecommerceProject.Ecommerce.project.model.Product;
import com.ecommerceProject.Ecommerce.project.repository.CategoryRepository;
import com.ecommerceProject.Ecommerce.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl  implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
        for(Category item : categoryList){
            categoryResponseDTOList.add(CategoryEntityDTOMapper.convertEntityToCategoryResponseDTO(item));
        }
        return categoryResponseDTOList;
    }

    @Override
    public CategoryResponseDTO getCategoryById(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()->new CategoryNotFoundException("Category not found for categoryId : "+categoryId)
        );
        return  CategoryEntityDTOMapper.convertEntityToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = CategoryEntityDTOMapper.createUpdateCategoryRequestToEntity(categoryRequestDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertEntityToCategoryResponseDTO(savedCategory);
    }

    @Override
    public CategoryResponseDTO updateCategory(CategoryRequestDTO categoryRequestDTO, UUID categoryId) {
       return null;
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
        return false;
    }

    @Override
    public long getTotalPriceForCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()->new CategoryNotFoundException("Category Not Found of CategoryID :"+categoryId)
        );

        List<Product> productList = productRepository.findByCategoryId(categoryId);
        long totalCost = 0;
        for(Product item:productList){
            System.out.println(item);
            totalCost += item.getPrice();
        }

        return totalCost;
    }

}


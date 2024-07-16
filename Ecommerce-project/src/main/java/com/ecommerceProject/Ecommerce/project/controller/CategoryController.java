package com.ecommerceProject.Ecommerce.project.controller;

import com.ecommerceProject.Ecommerce.project.DTO.CategoryRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.CategoryResponseDTO;
import com.ecommerceProject.Ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") UUID id){
        return ResponseEntity.ok( categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO>  createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID id,@RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategory(categoryRequestDTO,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

    @GetMapping("/totalPrice/{id}")
    public ResponseEntity<Long> getTotalPriceForCategory(@PathVariable("id") UUID id){
        return ResponseEntity.ok(categoryService.getTotalPriceForCategory(id));
    }

}

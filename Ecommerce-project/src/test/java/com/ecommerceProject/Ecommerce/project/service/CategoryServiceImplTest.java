package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.Exception.CategoryNotFoundException;
import com.ecommerceProject.Ecommerce.project.model.Category;
import com.ecommerceProject.Ecommerce.project.model.Product;
import com.ecommerceProject.Ecommerce.project.repository.CategoryRepository;
import com.ecommerceProject.Ecommerce.project.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); // not required nowadays. It initialises and adds all the required mocks
    }

    @Test
    public void getTotalPriceForCategoryForMultipleProducts(){
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptional = getCategory(categoryId);
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptional);

        List<Product> productList = getMockDataForMultipleProducts();
        Mockito.when(productRepository.findByCategoryId(categoryId)).thenReturn(productList);

        long totalExpectedcost = 850;
        //Act
        long totalActualCost = categoryService.getTotalPriceForCategory(categoryId);
        //Assert
        Assertions.assertEquals(totalExpectedcost,totalActualCost);
    }

    @Test
    public void getTotalPriceForCategoryNotFoundException(){
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryNotFound = Optional.empty();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryNotFound);

        //act and assert , becoz of exception
        Assertions.assertThrows(CategoryNotFoundException.class,()->categoryService.getTotalPriceForCategory(categoryId));
    }





    // arranging the Mock data based on the requirements
    private List<Product> getMockDataForMultipleProducts(){
        UUID categoryId = UUID.randomUUID();
        Category category = new Category();
        category.setName("CategoryName");
        category.setId(categoryId);

        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setPrice(100.00);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product2");
        product2.setPrice(700.00);
        product2.setCategory(category);

        Product product3 = new Product();
        product3.setId(UUID.randomUUID());
        product3.setTitle("Product3");
        product3.setPrice(50.00);
        product3.setCategory(category);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return productList;
    }

    public Optional<Category> getCategory(UUID categoryId){
        Category category = new Category();
        category.setName("CategoryName");
        category.setId(categoryId);

        return Optional.of(category);
    }


}

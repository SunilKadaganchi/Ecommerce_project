package com.ecommerceProject.Ecommerce.project.controller;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.model.Product;
import com.ecommerceProject.Ecommerce.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<FakeProductResponseDTO>> getAllProducts(){
        List<FakeProductResponseDTO> productsList = productService.getAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<FakeProductResponseDTO> getProductById(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newAddedProduct = productService.createProduct(product);

        return ResponseEntity.ok(newAddedProduct);
    }








    @GetMapping("/hello")
    public ResponseEntity hello(){
        return ResponseEntity.ok("Hello world");
     }

    @GetMapping("/greet")
    public  ResponseEntity greet(){
        return ResponseEntity.ok("Welcome to the Ecommerce..");
    }
}

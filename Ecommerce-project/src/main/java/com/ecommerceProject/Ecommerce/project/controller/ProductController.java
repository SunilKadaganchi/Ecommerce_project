package com.ecommerceProject.Ecommerce.project.controller;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.model.Product;
import com.ecommerceProject.Ecommerce.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productsList = productService.getAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newAddedProduct = productService.createProduct(product);

        return ResponseEntity.ok(newAddedProduct);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") UUID productId , @RequestBody Product product){
       Product updatedProduct = productService.updateProduct(productId,product);
       return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/product/{productId}")
    public  ResponseEntity<Boolean> deleteProduct(@PathVariable("productId")  UUID productId){
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }




}

package com.ecommerceProject.Ecommerce.project.controller;

import com.ecommerceProject.Ecommerce.project.DTO.ProductRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.ProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> productsList = productService.getAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO product){
        ProductResponseDTO newAddedProduct = productService.createProduct(product);

        return ResponseEntity.ok(newAddedProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("productId") UUID productId , @RequestBody ProductRequestDTO product){
        ProductResponseDTO updatedProduct = productService.updateProduct(productId,product);
       return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public  ResponseEntity<Boolean> deleteProduct(@PathVariable("productId")  UUID productId){
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }




}

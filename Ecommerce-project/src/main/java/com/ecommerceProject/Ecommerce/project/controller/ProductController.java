package com.ecommerceProject.Ecommerce.project.controller;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/hello")
    public ResponseEntity hello(){
        return ResponseEntity.ok("Hello world");
     }

     @GetMapping("/products")
    public ResponseEntity<List<FakeProductResponseDTO>> getAllProducts(){


        return null;
     }
}

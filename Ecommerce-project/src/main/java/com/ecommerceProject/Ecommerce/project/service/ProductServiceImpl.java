package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.Exception.ProductNotFoundException;
import com.ecommerceProject.Ecommerce.project.model.Product;
import com.ecommerceProject.Ecommerce.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) {
        Product savedProduct = productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException("Product not found with id :"+id)
        );
        return savedProduct;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(UUID productId, Product product) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product not found with id : "+productId)
        );
        savedProduct.setTitle(product.getTitle());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setCategory(product.getCategory());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setRating(product.getRating());
        savedProduct.setImageURL(product.getImageURL());

        return productRepository.save(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }
}

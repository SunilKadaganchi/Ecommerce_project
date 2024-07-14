package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.ProductRequestDTO;
import com.ecommerceProject.Ecommerce.project.DTO.ProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.Exception.CategoryNotFoundException;
import com.ecommerceProject.Ecommerce.project.Exception.ProductNotFoundException;
import com.ecommerceProject.Ecommerce.project.mapper.ProductEntityDTOMapper;
import com.ecommerceProject.Ecommerce.project.model.Category;
import com.ecommerceProject.Ecommerce.project.model.Product;
import com.ecommerceProject.Ecommerce.project.repository.CategoryRepository;
import com.ecommerceProject.Ecommerce.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for(Product item : productList){
          productResponseDTOList.add(ProductEntityDTOMapper.convertEntityToProductResponseDTO(item));
        }
        return productResponseDTOList;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) {
        Product savedProduct = productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException("Product not found with id :"+id)
        );
        return ProductEntityDTOMapper.convertEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findById(productRequestDTO.getCategory()).orElseThrow(
                ()->new CategoryNotFoundException("Category Not found for categoryId : "+productRequestDTO.getCategory())
        );
        Product product = ProductEntityDTOMapper.createUpdateProductRequestDTOToEntity(productRequestDTO);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return ProductEntityDTOMapper.convertEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(UUID productId, ProductRequestDTO product) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product not found with id : "+productId)
        );
        savedProduct.setTitle(product.getTitle());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setRating(product.getRating());
        savedProduct.setImageURL(product.getImageURL());

        return ProductEntityDTOMapper.convertEntityToProductResponseDTO(productRepository.save(savedProduct));
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }
}

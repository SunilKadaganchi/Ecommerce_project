package com.ecommerceProject.Ecommerce.project.service;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import com.ecommerceProject.Ecommerce.project.Exception.ProductNotFoundException;
import com.ecommerceProject.Ecommerce.project.client.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeProductServiceImpl implements ProductService{
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeProductResponseDTO> getAllProducts() {
        return fakeStoreClient.getAllProducts();
    }

    @Override
    public FakeProductResponseDTO getProductById(int id) {
        FakeProductResponseDTO product =  fakeStoreClient.getProductById(id);
        if(product==null){
            throw new ProductNotFoundException("Product is not found with id : "+id);
        }
        return product;
    }
}

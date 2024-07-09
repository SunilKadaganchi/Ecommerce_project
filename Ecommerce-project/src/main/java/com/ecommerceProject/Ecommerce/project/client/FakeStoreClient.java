package com.ecommerceProject.Ecommerce.project.client;

import com.ecommerceProject.Ecommerce.project.DTO.FakeProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakeStore.api.base.url}")
    private String fakeStoreApiBaseUrl;
    @Value("${fakeStore.api.products.path}")
    private String fakeStoreApiProductPath;

    public List<FakeProductResponseDTO> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String getProductsURL = fakeStoreApiBaseUrl.concat(fakeStoreApiProductPath);
      ResponseEntity<FakeProductResponseDTO[]> products =  restTemplate.getForEntity(getProductsURL, FakeProductResponseDTO[].class);

        return List.of(products.getBody());
    }

    public FakeProductResponseDTO getProductById(int id){
        String getProductByIdURL = fakeStoreApiBaseUrl.concat(fakeStoreApiProductPath).concat("/"+id);
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeProductResponseDTO> product = restTemplate.getForEntity(getProductByIdURL, FakeProductResponseDTO.class);

        return product.getBody();
    }


}

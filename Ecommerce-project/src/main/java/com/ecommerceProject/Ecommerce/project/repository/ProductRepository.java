package com.ecommerceProject.Ecommerce.project.repository;

import com.ecommerceProject.Ecommerce.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    public List<Product> findByCategoryId(UUID categoryId);
}

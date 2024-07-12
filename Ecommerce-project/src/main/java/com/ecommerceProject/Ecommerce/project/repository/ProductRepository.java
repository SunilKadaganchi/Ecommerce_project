package com.ecommerceProject.Ecommerce.project.repository;

import com.ecommerceProject.Ecommerce.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}

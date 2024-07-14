package com.ecommerceProject.Ecommerce.project.repository;

import com.ecommerceProject.Ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}

package com.ecommerceProject.Ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageURL;
    private double rating;
}

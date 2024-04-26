package com.Order.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private float productPrice;
    private String productType;

    public Product(float productPrice, String productType) {
        this.productPrice = productPrice;
        this.productType = productType;
    }

    public Product() {

    }
}

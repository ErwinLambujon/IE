package com.Order.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private int shopNo;

    public Stock(Product productId, int quantity, int shopNo) {
        this.product = productId;
        this.quantity = quantity;
        this.shopNo = shopNo;
    }

    public Stock(int quantity, int shopNo) {
        this.quantity = quantity;
        this.shopNo = shopNo;
    }

    public Stock() {

    }
}


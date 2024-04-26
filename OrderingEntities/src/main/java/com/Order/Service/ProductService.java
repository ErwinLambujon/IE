package com.Order.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Order.Models.Product;
import com.Order.Repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}

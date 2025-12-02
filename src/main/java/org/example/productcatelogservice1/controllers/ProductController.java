package org.example.productcatelogservice1.controllers;

import org.example.productcatelogservice1.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products")
    public List<Product>  getAllProducts() {
        Product prod1 = new Product();
        prod1.setId(1L);
        prod1.setPrice(2300D);
        List<Product> products = new ArrayList<>();
        products.add(prod1);
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        Product prod1 = new Product();
        prod1.setId(productId);
        prod1.setName("Product 1");
        prod1.setPrice(5500D);
        return prod1;
    }

}

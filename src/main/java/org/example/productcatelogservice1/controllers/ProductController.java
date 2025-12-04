package org.example.productcatelogservice1.controllers;

import org.example.productcatelogservice1.dtos.ProductDto;
import org.example.productcatelogservice1.models.Product;
import org.example.productcatelogservice1.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

//    public ProductController(IProductService productService) {
//        this.productService = productService;
//    }


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
    public Product getProductById(@PathVariable("id") Long id) {
        Product prod1 = new Product();
        prod1.setId(id);
        prod1.setName("Product 1");
        prod1.setPrice(5500D);
        return prod1;
    }

    @PostMapping("/products")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @PutMapping("/products")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @DeleteMapping("/products")
    public ProductDto deleteProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @PatchMapping("/products")
    public ProductDto patchProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }



}

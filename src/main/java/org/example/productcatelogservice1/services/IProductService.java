package org.example.productcatelogservice1.services;

import org.example.productcatelogservice1.models.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product product);
}

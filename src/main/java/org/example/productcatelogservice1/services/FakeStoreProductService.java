package org.example.productcatelogservice1.services;

import org.example.productcatelogservice1.dtos.FakeStoreProductDto;
import org.example.productcatelogservice1.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements  IProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, id);
        // todo FROM PRODUCT FROM PRODUCT-DTO
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}

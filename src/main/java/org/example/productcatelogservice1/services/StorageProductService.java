package org.example.productcatelogservice1.services;

import org.example.productcatelogservice1.models.Product;
import org.example.productcatelogservice1.models.State;
import org.example.productcatelogservice1.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
@Service("sps")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
//        return productOptional.orElse(null);
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
//        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepo.findById(id);
//        return productOptional.orElse(null);
        if (productOptional.isPresent()) {
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product productToDelete = productOptional.get();
            if(productToDelete.getState().equals(State.ACTIVE)) {
                productToDelete.setState(State.DELETED);
                productRepo.save(productToDelete);
            } else {
                productRepo.deleteById(id);
            }
        }
    }
}

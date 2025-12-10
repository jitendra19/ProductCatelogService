package org.example.productcatelogservice1.repos;

import jakarta.transaction.Transactional;
import org.example.productcatelogservice1.models.Category;
import org.example.productcatelogservice1.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {
    @Autowired
    CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchType() {
        Optional<Category> cat = categoryRepo.findById(6L);
        System.out.println(cat.get().getName());

        for(Product product: cat.get().getProducts()){
            System.out.println(product.getName());
        }


    }
}
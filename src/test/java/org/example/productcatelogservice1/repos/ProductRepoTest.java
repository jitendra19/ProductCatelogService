package org.example.productcatelogservice1.repos;

import jakarta.transaction.Transactional;
import org.example.productcatelogservice1.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductRepoTest {
    @Autowired
    ProductRepo productRepo;

    @Test
    @Transactional
    void findProductBetween() {
        List<Product> products = productRepo.findProductByPriceBetween(0D,324D);
        System.out.println(products.size() + " products found");
    }

    @Test
    @Transactional
    void findProductsOrderByPrice() {
        List<Product> products = productRepo.findAllByOrderByPrice();
        System.out.println(products.size() + " Ordered products found");
        System.out.println("ID" + " - " + "PRICE");
        for(Product p : products) {
            System.out.println(p.getId() + " - " + p.getPrice());
        }
    }

    @Test
    @Transactional
    void getProductId() {
        System.out.println(productRepo.getMeAProductIdWhosePriceIs(324D));
    }
}
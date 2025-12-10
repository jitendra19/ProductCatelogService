package org.example.productcatelogservice1.repos;

import org.example.productcatelogservice1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    @Override
    void deleteById(Long id);

    List<Product> findAllByOrderByPrice();

    List<Product> findProductByPriceBetween(Double priceFrom, Double priceTo);

    @Query("select p.name from products p where p.price = :p  order by p.id limit 1")
    String getMeAProductIdWhosePriceIs(Double p);


}
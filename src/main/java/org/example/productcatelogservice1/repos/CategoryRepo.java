package org.example.productcatelogservice1.repos;

import org.example.productcatelogservice1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long a);
}

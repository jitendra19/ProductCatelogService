package org.example.productcatelogservice1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name="categories")
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> products;
}

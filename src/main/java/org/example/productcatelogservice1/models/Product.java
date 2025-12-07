package org.example.productcatelogservice1.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="products")
public class Product extends BaseModel {
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

}

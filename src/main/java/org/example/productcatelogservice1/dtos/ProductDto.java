package org.example.productcatelogservice1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatelogservice1.models.Category;

@Getter
@Setter
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private CategoryDto categoryDto;
}

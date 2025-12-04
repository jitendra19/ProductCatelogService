package org.example.productcatelogservice1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatelogservice1.models.Product;

import java.util.List;

@Setter
@Getter
public class CategoryDto {
    private long id;
    private String categoryName;
    private String categoryDescription;
}

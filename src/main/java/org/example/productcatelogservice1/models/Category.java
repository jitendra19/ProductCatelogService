package org.example.productcatelogservice1.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Category extends BaseModel {
    private String categoryName;
    private String categoryDescription;
    private List<Product> products;
}

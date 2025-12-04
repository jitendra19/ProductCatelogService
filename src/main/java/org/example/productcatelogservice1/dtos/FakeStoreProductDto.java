package org.example.productcatelogservice1.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private String price;
}

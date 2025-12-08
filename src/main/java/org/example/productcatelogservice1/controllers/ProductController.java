package org.example.productcatelogservice1.controllers;

import org.example.productcatelogservice1.dtos.ProductDto;
import org.example.productcatelogservice1.dtos.CategoryDto;
import org.example.productcatelogservice1.exception.ProductNotFoundException;
import org.example.productcatelogservice1.models.Product;
import org.example.productcatelogservice1.models.Category;
import org.example.productcatelogservice1.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

//    public ProductController(IProductService productService) {
//        this.productService = productService;
//    }


    @GetMapping
    public List<Product>  getAllProducts() {
        Product prod1 = new Product();
        prod1.setId(1L);
        prod1.setPrice(2300D);
        List<Product> products = new ArrayList<>();
        products.add(prod1);
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
//        try {
            if(id <= 0) {
                throw new IllegalArgumentException("please pass id > 0");
            }
            Product product = productService.getProductById(id);
            if(product != null) {
                ProductDto resp = from(product);
                return new ResponseEntity<>(resp, HttpStatus.OK);
            }
//            else {
//                throw new NullPointerException("Not a valid response");
                throw new ProductNotFoundException("product id should be < 20");
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>((ProductDto) null, HttpStatusCode.valueOf(404));
//        }
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createProduct(from(productDto));
        return from(product);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable long id,  @RequestBody ProductDto productDto) {
       Product product =  productService.replaceProduct(id, from(productDto));
       return from(product);
    }

    @DeleteMapping
    public ProductDto deleteProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @PatchMapping
    public ProductDto patchProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }


    private ProductDto  from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            Long categoryIdWrapper = product.getCategory().getId();
            long categoryId = (categoryIdWrapper == null) ? 0L : categoryIdWrapper.longValue();
            categoryDto.setId(categoryId);
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());

        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }

}

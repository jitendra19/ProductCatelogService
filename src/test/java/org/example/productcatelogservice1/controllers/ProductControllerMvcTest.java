package org.example.productcatelogservice1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatelogservice1.dtos.ProductDto;
import org.example.productcatelogservice1.models.Product;
import org.example.productcatelogservice1.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerMvcTest {

    @MockBean
    private IProductService productService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllProducts_runSuccessfully() throws Exception {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Mac");
        product1.setPrice(100000D);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Windows");
        product2.setPrice(200000D);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(productService.getAllProducts()).thenReturn(productList);

        ProductDto productDto1 = new ProductDto();
        productDto1.setName("Mac");
        productDto1.setPrice(100000D);
        productDto1.setId(1L);

        ProductDto productDto2 = new ProductDto();
        productDto2.setName("Windows");
        productDto2.setPrice(200000D);
        productDto2.setId(2L);

        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(productDto1);
        productDtoList.add(productDto2);

        String expectedResponse = objectMapper.writeValueAsString(productDtoList);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));


    }

}
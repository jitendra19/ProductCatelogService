package org.example.productcatelogservice1.controllers;

import jakarta.transaction.Transactional;
import org.example.productcatelogservice1.dtos.ProductDto;
import org.example.productcatelogservice1.exception.ProductNotFoundException;
import org.example.productcatelogservice1.models.Product;
import org.example.productcatelogservice1.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void testGetProductById_withValidId_returnProductSuccessfully() {
        long id = 4L;
        Product product = new Product();
        product.setId(id);
        product.setName("Laptop");

        when(productService.getProductById(id)).thenReturn(product);

        ResponseEntity<ProductDto> respEntity = productController.getProductById(id);
        assertNotNull(respEntity);
        assertNotNull(respEntity.getBody());
        assertEquals(id, respEntity.getBody().getId());
        assertEquals("Laptop", respEntity.getBody().getName());
        assertEquals(respEntity.getStatusCode().value(), HttpStatus.OK.value());
        assertNull(null, respEntity.getBody().getDescription());
    }

    @Test
    public void testGetProductById_WithNegative_returnInllegalArgumentException() {
        long id = -1L;

        Exception exp =  assertThrows
                (IllegalArgumentException.class, ()->productController.getProductById(id));
        assertEquals("please pass id > 0", exp.getMessage());

        verify(productService, times(0)).getProductById(anyLong());
    }

    @Test
    public void testGetProductById_WithInvalidID_returnProductNotFoundException() {
        long id = 200L;

        Exception exp = assertThrows
                (ProductNotFoundException.class, ()->productController.getProductById(id));
        assertEquals("product with requested id is not found;", exp.getMessage());
    }

    @Test
    public void testGetProductById_whereProductServiceThrowsRunTimeException_resultsInRunTimeException() {
        long id = 3L;
        when(productService.getProductById(id)).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, ()->productController.getProductById(id));
    }

}
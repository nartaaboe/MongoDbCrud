package com.example.mongodbcrud.service;

import com.example.mongodbcrud.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @AfterEach
    void tearDown() throws Exception {
    }

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    void canFindAll() {
        //when
        productService.findAll();
        //then
        verify(productRepository).findAll();
    }

    @Test
    @Disabled
    void addProduct() {
    }

    @Test
    @Disabled
    void deleteProduct() {
    }
}
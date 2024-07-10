package com.example.mongodbcrud.Product;


import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @AfterEach
    public void tearDown() {
        productRepository.deleteAll();
    }
    @Test
    void testFindByName(){
        //given
        Product product = new Product("Iphone 15", 25);
        productRepository.save(product);
        //when
        Product foundProduct = productRepository.findByName("Iphone 15").orElseThrow();
        //then
        assertThat(foundProduct.getName()).isEqualTo("Iphone 15");
        assertThat(foundProduct.getQuantity()).isEqualTo(25);
    }
}

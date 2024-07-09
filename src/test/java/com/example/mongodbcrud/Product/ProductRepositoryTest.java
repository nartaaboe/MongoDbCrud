package com.example.mongodbcrud.Product;


import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    void testFindByName(){
        //given
        Product product = new Product("Iphone 15", 25);
        productRepository.save(product);
        //when
        Product foundProduct = productRepository.findByName("Iphone 15");
        //then
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getName()).isEqualTo("Iphone 15");
        assertThat(foundProduct.getQuantity()).isEqualTo(25);
        //clean up
        productRepository.delete(foundProduct);
    }
}

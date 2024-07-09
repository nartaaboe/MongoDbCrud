package com.example.mongodbcrud.config;

import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.repository.ProductRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "001", id = "seeDatabase", author = "Sai")
    public void seeDatabase(ProductRepository productRepository){
        List<Product> productList = new ArrayList<>();
        productList.add(createNewProduct("Mouse", 5));
        productList.add(createNewProduct("Headphones", 24));
        productList.add(createNewProduct("USB", 10));
        productRepository.insert(productList);
    }
    private Product createNewProduct(String name, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        return product;
    }
}

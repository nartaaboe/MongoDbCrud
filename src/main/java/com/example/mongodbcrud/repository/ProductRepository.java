package com.example.mongodbcrud.repository;

import com.example.mongodbcrud.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{name: '?0'}")
    Product findByName(String name);
}

package com.example.mongodbcrud.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

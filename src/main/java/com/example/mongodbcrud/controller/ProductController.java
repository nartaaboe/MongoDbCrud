package com.example.mongodbcrud.controller;

import com.example.mongodbcrud.repository.ProductRepository;
import com.example.mongodbcrud.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/{name}")
    public Product getProductByName(@PathVariable String name){
        return productRepository.findByName(name);
    }
    @PostMapping
    public String saveProduct(@RequestBody Product product){
        productRepository.save(product);
        return "product saved.";
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return "product deleted.";
    }
}

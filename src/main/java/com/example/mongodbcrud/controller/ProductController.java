package com.example.mongodbcrud.controller;

import com.example.mongodbcrud.repository.ProductRepository;
import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getProducts(){
        return productService.findAll();
    }
    @GetMapping("/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.findByName(name);
    }
    @PostMapping
    public String saveProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "product saved.";
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return "product deleted.";
    }
}

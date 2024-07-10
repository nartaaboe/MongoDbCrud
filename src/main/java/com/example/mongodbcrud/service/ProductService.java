package com.example.mongodbcrud.service;

import com.example.mongodbcrud.exception.BadRequestException;
import com.example.mongodbcrud.exception.ProductNotFoundException;
import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public Product findByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public void addProduct(Product product){
        Boolean existsName = productRepository.existsByName(product.getName());
        if (existsName) {
            throw new BadRequestException("Name " + product.getName() + " taken");
        }
        productRepository.save(product);
    }
    public void deleteProduct(String id) {
        if(!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with id " +  id + " does not exist");
        }
        productRepository.deleteById(id);
    }
}

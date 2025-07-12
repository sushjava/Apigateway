package com.example.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
 @Autowired
	private ProductRepository productRepository;
 
 //create product
 
 @PostMapping
 public Product addProduct(@RequestBody Product product) {
	return productRepository.save(product);
	 
 }
 
 //Get All products
 @GetMapping
 public List<Product> getAllProducts(){
	 return productRepository.findAll();
	 }
 //Get product Id
 @GetMapping("/{productId}")
public ResponseEntity<Product> getProductId(@PathVariable Long productId){
	Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found with Id "+productId));
	return ResponseEntity.ok(product);
	 
	 
 }
}


package com.spring.controller;

import com.spring.model.Product;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.save(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public String getAny(){
        return "Hello e commerce";
    }



}

package com.spring.controller;

import com.spring.exception.Response;
import com.spring.exception.ResponseBuilder;
import com.spring.model.Product;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    public Response InsertProduct( @Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseBuilder.getFailureResponse(result, "Bean binding error");
        }
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Response UpdateProduct(@PathVariable("id")Long id, @Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseBuilder.getFailureResponse(result, "Bean binding error");
        }
        return productService.update(id, product);
    }

    @GetMapping
    public Response getAllBookings() {
        return productService.list();
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable("id") Long id) {
        return productService.getOne(id);
    }




}

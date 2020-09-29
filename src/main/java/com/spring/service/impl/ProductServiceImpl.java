package com.spring.service.impl;

import com.spring.model.Product;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}

package com.spring.service;

import com.spring.exception.Response;
import com.spring.model.Product;

public interface ProductService {

    Response save(Product product);
    Response update(Long id,Product product);
    Response list( );
    Response getOne(Long id);
    Response delete(Long id);


}

package com.spring.service.impl;

import com.spring.exception.Response;
import com.spring.exception.ResponseBuilder;
import com.spring.model.Product;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Response save(Product product) {
        if(product !=null){
            final Product save = productRepository.save(product);
            return  ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, " Product created Successfully", save);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
    }

    @Override
    public Response update(Long id,Product product) {
        if(product !=null){
            product=productRepository.save(product);
            return  ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, " created Successfully", product);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
    }

    @Override
    public Response list() {
        List<Product> products = productRepository.findAll();

        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, " retrieved Successfully", products);
    }

    @Override
    public Response getOne(Long id) {
        Product product =productRepository.findById(id).get();
        if (product !=null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, " retrieved Successfully",product);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, " not found");
    }

    @Override
    public Response delete(Long id) {
        Product product =productRepository.findById(id).get();
        if (product !=null) {
            productRepository.deleteById(id);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, " delete Successfully",product);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, " not found");
    }
}

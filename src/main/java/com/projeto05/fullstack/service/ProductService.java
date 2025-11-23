package com.projeto05.fullstack.service;

import com.projeto05.fullstack.model.ProductModel;
import com.projeto05.fullstack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<ProductModel> list() {} {
        return productRepository.findAll();
    }
}

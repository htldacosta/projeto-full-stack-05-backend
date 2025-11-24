package com.projeto05.fullstack.service;

import com.projeto05.fullstack.model.ProductModel;
import com.projeto05.fullstack.model.ResponseModel;
import com.projeto05.fullstack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ResponseModel responseModel;

    public List<ProductModel> listAll() {
        return productRepository.findAll();
    }

    // Serve tanto para cadastrar quanto para atualizar
    public ProductModel saveOrUpdate(ProductModel productModel) {

        return productRepository.save(productModel);
    }

    // Method for remove products
    public void remove(Long id){
        productRepository.deleteById(id);
    }
}

package com.projeto05.fullstack.service;

import com.projeto05.fullstack.model.ProductModel;
import com.projeto05.fullstack.model.ResponseModel;
import com.projeto05.fullstack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ResponseModel responseModel;

    public Iterable<ProductModel> list() {
        return productRepository.findAll();
    }

    public ResponseEntity<?> register(ProductModel productModel) {

        if(productModel.getName().equals("")){
            responseModel.setMensagem("O nome do produto é obrigatorio!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        }else if(productModel.getMark().equals("")){
            responseModel.setMensagem("O nome da marca é obrigatorio!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<ProductModel>(productRepository.save(productModel), HttpStatus.CREATED);
        }
    }
}

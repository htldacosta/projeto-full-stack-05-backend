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

    public ResponseEntity<?> registerUpdate(ProductModel productModel, String acao) {

        if(productModel.getName().equals("")){
            responseModel.setMensagem("O nome do produto é obrigatorio!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        }else if(productModel.getMark().equals("")){
            responseModel.setMensagem("O nome da marca é obrigatorio!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        }else{
           if(acao.equals("register")){
               return new ResponseEntity<ProductModel>(productRepository.save(productModel), HttpStatus.CREATED);
           }else {
               return new ResponseEntity<ProductModel>(productRepository.save(productModel), HttpStatus.OK);
           }
        }
    }

    // Method for remove products
    public ResponseEntity<ResponseModel> remove(long codigo){
        productRepository.deleteById(codigo);

        responseModel.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
}

package com.projeto05.fullstack.controller;

import com.projeto05.fullstack.model.ProductModel;
import com.projeto05.fullstack.model.ResponseModel;
import com.projeto05.fullstack.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ResponseModel responseModel;

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> remove(@PathVariable Long id){
        productService.remove(id);
        responseModel.setMensagem("Product removed sucessfully");
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }


    @PutMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody ProductModel productModel){
        return new ResponseEntity<>(productService.saveOrUpdate(productModel), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody ProductModel productModel) {
        return new ResponseEntity<>(productService.saveOrUpdate(productModel), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public Iterable<ProductModel> list(){
        return productService.listAll();
    }
}

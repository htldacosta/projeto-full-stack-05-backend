package com.projeto05.fullstack.controller;

import com.projeto05.fullstack.model.ProductModel;
import com.projeto05.fullstack.model.ResponseModel;
import com.projeto05.fullstack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @DeleteMapping("/remove/{codigo}")
    public ResponseEntity<ResponseModel> remove(@PathVariable long codigo){
        return productService.remove(codigo);
    }


    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody ProductModel productModel){
        return productService.registerUpdate(productModel, "register");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ProductModel productModel) {
        return productService.registerUpdate(productModel, "register");
    }

    @GetMapping("/list")
    public Iterable<ProductModel> listProduct(){
        return productService.list();
    }
}

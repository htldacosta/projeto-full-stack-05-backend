package com.projeto05.fullstack.controller;

import com.projeto05.fullstack.model.ProductModel;
import com.projeto05.fullstack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public Iterable<ProductModel> listProduct(){
        return productService.list();
    }
}

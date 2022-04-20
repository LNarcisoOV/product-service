package com.msarch.ps.controller;

import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;
import com.msarch.ps.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO){
        Product product = productService.insert(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}

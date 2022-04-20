package com.msarch.ps.controller;

import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;
import com.msarch.ps.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> insert(@Valid @RequestBody ProductDTO productDTO){
        Product product = productService.insert(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product get(@PathVariable Long productId){
        return productService.get(productId);
    }
}

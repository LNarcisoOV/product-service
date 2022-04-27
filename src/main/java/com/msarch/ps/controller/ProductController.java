package com.msarch.ps.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        Product product = productService.save(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product get(@PathVariable Long productId){
        return productService.get(productId);
    }

    @PatchMapping("/{product_id}")
    public Product patch(@PathVariable("product_id") Long productId, @RequestBody JSonPatch jSonPatch) throws JsonPatchException, JsonProcessingException {
        Product product = productService.get(productId);
        return productService.updateByPatch(product, jSonPatch);
    }

    @DeleteMapping("/{product_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("product_id") Long productId) {
        productService.delete(productId);
    }

    @PutMapping("/{product_id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateAll(@PathVariable("product_id") Long productId, @RequestBody ProductDTO productDTO) {
        return productService.update(productId, productDTO);
    }

}

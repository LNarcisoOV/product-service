package com.msarch.ps.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import javax.persistence.NoResultException;

public interface ProductService {
    Product save(ProductDTO productDTO);

    Product get(Long id) throws NoResultException;

    Product updateByPatch(Product product, JSonPatch jSonPatch) throws JsonPatchException, JsonProcessingException;
}

package com.msarch.ps.service;

import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import javax.persistence.NoResultException;

public interface ProductService {
    Product insert(ProductDTO productDTO);

    Product get(Long id) throws NoResultException;
}

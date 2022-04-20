package com.msarch.ps.service;

import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;

public interface ProductService {
    Product insert(ProductDTO productDTO);
}

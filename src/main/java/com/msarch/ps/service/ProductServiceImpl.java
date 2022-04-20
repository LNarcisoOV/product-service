package com.msarch.ps.service;

import com.msarch.ps.model.Product;
import com.msarch.ps.model.dto.ProductDTO;
import com.msarch.ps.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public Product insert(ProductDTO productDTO){
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getValue());
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product get(Long productId) {
        return Optional.of(productRepository.getById(productId)).orElseThrow(() -> new NoResultException(String.format("Product with id %d not found.", productId)));
    }
}

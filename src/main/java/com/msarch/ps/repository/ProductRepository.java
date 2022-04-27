package com.msarch.ps.repository;

import com.msarch.ps.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

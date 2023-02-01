package com.luv2code.springbootecommerce.services;

import com.luv2code.springbootecommerce.dao.ProductRepository;
import com.luv2code.springbootecommerce.model.Product;
import com.luv2code.springbootecommerce.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> findByCategoryId(ProductCategory category, Pageable pageable){
        return productRepository.findByCategory(category, pageable);
    }

    public Page<Product> findByNameContaining(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}

package com.luv2code.springbootecommerce.services;

import com.luv2code.springbootecommerce.dao.ProductCategoryRepository;
import com.luv2code.springbootecommerce.dao.ProductRepository;
import com.luv2code.springbootecommerce.model.Product;
import com.luv2code.springbootecommerce.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

}

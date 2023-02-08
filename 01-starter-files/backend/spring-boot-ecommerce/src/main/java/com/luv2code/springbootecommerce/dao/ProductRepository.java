package com.luv2code.springbootecommerce.dao;

import com.luv2code.springbootecommerce.model.Product;
import com.luv2code.springbootecommerce.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategory(ProductCategory category, Pageable pageable);
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);


}

package com.luv2code.springbootecommerce.controllers;

import com.luv2code.springbootecommerce.model.Product;
import com.luv2code.springbootecommerce.model.ProductCategory;
import com.luv2code.springbootecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Product>> findByCategory(ProductCategory category, Pageable pageable) {
        Page<Product> products = productService.findByCategoryId(category, pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/productss")
    public Page<Product> getProductsByName(@RequestParam("name") String name, Pageable pageable) {
        return productService.findByNameContaining(name, pageable);
    }


    @GetMapping("/products/search")
    public ResponseEntity<Page<Product>> searchProductsByName(@RequestParam("name") String name, Pageable pageable) {
        Page<Product> products = productService.findByNameContaining(name,pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}

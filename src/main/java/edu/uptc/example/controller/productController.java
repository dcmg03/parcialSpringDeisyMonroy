package edu.uptc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import parcialSpringDeisyMonroy.entities.product;
import parcialSpringDeisyMonroy.responses.ResponseHandler;
import parcialSpringDeisyMonroy.services.ProductService;

@RestController
public class productController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Object> findAllProducts() {

        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, productService.findAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @PostMapping("/saveProduct")
    public ResponseEntity<Object> addProducts(@RequestBody product product) {
        try {
            return ResponseHandler.generateResponse("Product added successfully", HttpStatus.CREATED, productService.saveProduct(product));

        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

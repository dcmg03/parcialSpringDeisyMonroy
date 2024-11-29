package edu.uptc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcialSpringDeisyMonroy.entities.customers;
import parcialSpringDeisyMonroy.entities.product;
import parcialSpringDeisyMonroy.entities.sale;
import parcialSpringDeisyMonroy.responses.ResponseHandler;
import parcialSpringDeisyMonroy.services.SaleService;

import java.util.List;

@RestController
public class saleController {

    @Autowired
    private SaleService saleService;


    @GetMapping("/sales/{saleId}/customer")
    public ResponseEntity<Object> getCustomerBySaleId(@PathVariable Integer saleId) {
        try {
            customers customer = saleService.getCustomerBySaleId(saleId);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, customer);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/products/{productId}/stock")
    public ResponseEntity<Object> validateProductStock(@PathVariable Integer productId, @RequestParam Integer quantity) {
        try {
            boolean isStockAvailable = saleService.validateProductStock(productId, quantity);
            if (isStockAvailable) {
                return ResponseHandler.generateResponse("Stock disponible", HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("No hay suficiente stock disponible", HttpStatus.BAD_REQUEST, null);
            }
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


    @GetMapping("/{saleId}/products")
    public ResponseEntity<Object> getProductsBySaleId(@PathVariable Integer saleId) {
        try {
            List<product> products = saleService.getProductsBySaleId(saleId);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/saveSale")
    public ResponseEntity<Object> addSale(@RequestParam Integer customerId,
                                          @RequestParam Integer productId,
                                          @RequestParam Integer quantity) {
        try {
            sale sale = saleService.saveSale(customerId, productId, quantity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Venta agregada exitosamente. ID de la venta: " + sale.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

}

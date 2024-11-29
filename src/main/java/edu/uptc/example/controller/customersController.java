package edu.uptc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class customersController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<Object> findAllCustomers() {

        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, customerService.findAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Object> addCustomer(@RequestBody customers customers) {
        try {
            return ResponseHandler.generateResponse("Customer added successfully", HttpStatus.CREATED, customerService.saveCustomer(customers));

        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/costumers/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Integer id) {
        try {
            customers customer = customerService.findById(id);
            if (customer != null){

                customerService.deleteCustomer(customer);

                return ResponseHandler.generateResponse("Success Customer", HttpStatus.ACCEPTED, customer);

            }
            return ResponseHandler.generateResponse("Success Agent", HttpStatus.NOT_FOUND, null);

        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

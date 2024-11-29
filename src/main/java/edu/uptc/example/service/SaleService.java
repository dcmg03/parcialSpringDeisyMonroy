package edu.uptc.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.uptc.example.entityes.customers;
import edu.uptc.example.entityes.product;
import edu.uptc.example.entityes.sale;
import edu.uptc.example.repository.SaleRepository;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;


    public customers getCustomerBySaleId(Integer saleId) {
        sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con el ID: " + saleId));

        return sale.getCustomer();
    }

    public boolean validateProductStock(Integer productId, Integer quantity) {
        int availableStock = productService.getProductStock(productId);
        return availableStock >= quantity;
    }

    public List<product> getProductsBySaleId(Integer saleId) {
        return saleRepository.findProductsById(saleId);
    }

    public sale saveSale(Integer customerId, Integer productId, Integer quantity) {
        if (!validateProductStock(productId, quantity)) {
            throw new IllegalArgumentException("No hay suficiente stock disponible para el producto con ID: " + productId);
        }
        productService.decreaseProductStock(productId, quantity);
        customers customer = customerService.findById(customerId);

        sale sale = new sale();
        sale.setCustomer(customer);

        product product = productService.findById(productId);
        for (int i = 0; i < quantity; i++) {
            sale.addProduct(product);
        }

        return saleRepository.save(sale);
    }


}

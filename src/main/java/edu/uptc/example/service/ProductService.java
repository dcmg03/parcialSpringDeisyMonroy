package edu.uptc.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.uptc.example.entityes.product;
import edu.uptc.example.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<product> findAll(){
        return productRepository.findAll();
    }

    public product findById(Integer id){
        Optional<product> optional = productRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }
    public product saveProduct (product product){
        return productRepository.save(product);
    }

    public int getProductStock(Integer productId) {
        product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con el ID: " + productId));

        return product.getStock();
    }

    public void decreaseProductStock(Integer productId, Integer quantity) {
        product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con el ID: " + productId));

        int currentStock = product.getStock();
        if (currentStock < quantity) {
            throw new IllegalArgumentException("No hay suficiente stock disponible para el producto con ID: " + productId);
        }

        product.setStock(currentStock - quantity);
        productRepository.save(product);
    }

}

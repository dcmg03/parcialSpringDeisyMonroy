package edu.uptc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.uptc.example.entityes.product;
import edu.uptc.example.entityes.sale;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<sale, Integer> {

    List<product> findProductsById(Integer saleId);
}

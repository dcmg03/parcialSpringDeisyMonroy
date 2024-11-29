package edu.uptc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcialSpringDeisyMonroy.entities.product;
import parcialSpringDeisyMonroy.entities.sale;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<sale, Integer> {

    List<product> findProductsById(Integer saleId);
}

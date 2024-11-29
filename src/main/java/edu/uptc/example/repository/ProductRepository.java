package edu.uptc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcialSpringDeisyMonroy.entities.product;

@Repository
public interface ProductRepository extends JpaRepository<product, Integer> {
}

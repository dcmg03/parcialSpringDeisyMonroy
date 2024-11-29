package edu.uptc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.uptc.example.entityes.product;

@Repository
public interface ProductRepository extends JpaRepository<product, Integer> {
}

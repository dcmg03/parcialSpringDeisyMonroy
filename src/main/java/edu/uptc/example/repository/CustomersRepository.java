package edu.uptc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcialSpringDeisyMonroy.entities.customers;

@Repository
public interface CustomersRepository extends JpaRepository<customers, Integer> {
}


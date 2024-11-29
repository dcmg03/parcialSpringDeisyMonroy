package edu.uptc.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.uptc.example.entityes.customers;

@Repository
public interface CustomersRepository extends JpaRepository<customers, Integer> {
}


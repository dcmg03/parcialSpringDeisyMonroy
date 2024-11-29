package edu.uptc.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.uptc.example.entityes.customers;
import edu.uptc.example.repository.CustomersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomersRepository customersRepository;

    public List<customers> findAll(){
        return customersRepository.findAll();
    }

    public customers findById(Integer id){
        Optional<customers> optional = customersRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }
    public customers saveCustomer (customers customers){
        return customersRepository.save(customers);
    }

    public void deleteCustomer (customers customers){
        customersRepository.delete(customers);
    }

}

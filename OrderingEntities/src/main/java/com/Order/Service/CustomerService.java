package com.Order.Service;

import com.Order.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Order.Models.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCostumer(Customer customer) {
        return customerRepository.save(customer);
    }


    public List<Customer> queryAll() {
        return customerRepository.findAll();
    }

    public Customer editCostumer(Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(updatedCustomer.getCostumerId()).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setCostumerName(updatedCustomer.getCostumerName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return customerRepository.save(existingCustomer);
        }
        return null; // or throw an exception if needed
    }

    public Customer deleteCostumer(Long costumerId) {
        Optional<Customer> deletedCostumer = customerRepository.findById(costumerId);
        if(deletedCostumer.isPresent()) {
            customerRepository.deleteById(costumerId);
        }
        return deletedCostumer.get();
    }
}


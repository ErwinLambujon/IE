package com.Order.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Order.Models.Customer;
import com.Order.Service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustumers")
    private ResponseEntity<?> getAllCostumer() {
        return ResponseEntity.ok(customerService.queryAll());
    }

    @PostMapping("/addCustumer")
    private ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Customer costumer = customerService.createCostumer(customer);
        return ResponseEntity.ok(costumer);
    }

    @PutMapping("/editcostumer")
    private ResponseEntity<?> editCustomer(@RequestBody Customer updatedCustomer) {
        Customer editedCustomer = customerService.editCostumer(updatedCustomer);
        if (editedCustomer != null) {
            return ResponseEntity.ok(editedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletecostumer/{id}")
    private ResponseEntity<?> deleteCostumer(@PathVariable Long id) {
        Customer editedCustomer = customerService.deleteCostumer(id);
        if (editedCustomer != null) {
            return ResponseEntity.ok(editedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

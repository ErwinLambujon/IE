package com.Order.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumerId;

    private String costumerName;
    private String address;
    private Long phoneNumber;

    public Customer(String costumerName, String address, Long phoneNumber) {
        this.costumerName = costumerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public Customer() {

    }

    @Override
    public String toString() {
        return costumerName;
    }
}

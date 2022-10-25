package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;


    @OneToMany(mappedBy = "customer")
    private List<Payment> payment;

    public Customer(String address, String email, String name, String surName, String userName, List<Payment> payment) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.payment = payment;
    }
}

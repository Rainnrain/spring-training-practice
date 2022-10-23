package com.cydeo.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.math.BigDecimal;
@MappedSuperclass
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}

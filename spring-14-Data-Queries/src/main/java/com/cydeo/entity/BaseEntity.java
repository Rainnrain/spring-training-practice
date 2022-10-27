package com.cydeo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
  //  @GeneratedValue(strategy = GenerationType.IDENTITY) ALready given
    @Id
    private Long id;
}

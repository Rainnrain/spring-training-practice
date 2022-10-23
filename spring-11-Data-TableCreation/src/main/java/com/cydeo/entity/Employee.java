package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="employees")

public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;

    public Employee(String firstName, String lastName, String email, LocalDate date, Gender gender, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date = date;
        this.gender = gender;
        this.salary = salary;
    }


}

package com.cydeo.entity;

import com.cydeo.Enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee extends BaseEntity{
private String firstName;
private String lastName;
private String email;
 @Column(columnDefinition = "DATE")
private LocalDate hireDate;
@OneToOne
@JoinColumn(name="department")
private Department department;
@Enumerated(EnumType.STRING)
private Gender gender;
private Integer salary;
@OneToOne
private Region region;


}

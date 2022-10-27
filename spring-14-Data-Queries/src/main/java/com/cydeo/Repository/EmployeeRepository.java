package com.cydeo.Repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Display all employees with email address as " ";

    List<Employee> findByEmail(String str);

    // Display all employees with first name as "" and last name as ""
    // Also show all employees with an email address

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all emoloyees that their first name is not ""

    List<Employee> findByFirstNameIsNot(String str);

    // Display all employees where last name starts with ""

    List<Employee> findByLastNameStartsWith(String str);

    //Display all employees with salaries higher than ""

    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries lower than ""

    List<Employee> findBySalaryLessThan(Integer salary);


}

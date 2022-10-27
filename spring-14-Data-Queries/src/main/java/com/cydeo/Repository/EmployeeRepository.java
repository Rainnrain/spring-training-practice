package com.cydeo.Repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
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

    // Display all employees that have been hired between "" and ""

    List <Employee> findByHireDateBetween(LocalDate x, LocalDate y);

    // Display all the employees with the salaries greater and equal to "" and in order

    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that are making less than ""

    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have an email address

    List<Employee> findByEmailIsNull();

    // ---------------------------JPQL------------------

    @Query("SELECT e FROM Employee e where e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e where e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

}

package com.cydeo.Repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // Not equal

    @Query("SELECT e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);


    //Like / Contains / StartsWiths / Endswith
    @Query("select e from Employee e where e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    // Less than
    @Query("select e from Employee e where e.salary <?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    // Greater than
    @Query("select e.firstName from Employee e where e.salary >?1")
    List<String> retrieveEmployeeSalaryGrreaterThan(int salary);

    // Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getRangeOfSalaries(Integer a, Integer b);

    // Before novemeber)
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> gethiredBeforeSetDate(LocalDate a);

    // null
    @Query("SELECT e from Employee  e WHERE e.email is null" )
    List<Employee> retreiveEmployeeEmailIsNull();

    // Sorting in Acs order
    @Query("select e from Employee e ORDER BY e.salary ASC ")
    List<Employee> retrieveEmployeeSalaryOrder();

    // Sorting in Dcs order
    @Query("select e from Employee e ORDER BY e.salary DESC ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native Query
    @Query(value = "SELECT * from employees WHERE salary=?1", nativeQuery=true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);


    //Named Parameter

    @Query("select e from Employee  e where e.salary =:salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);


}

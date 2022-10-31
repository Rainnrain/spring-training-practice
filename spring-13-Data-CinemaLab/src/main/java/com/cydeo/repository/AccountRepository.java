package com.cydeo.repository;

import com.cydeo.entity.Account;

import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state

List<Account> findAccountByCountryOrState(String country, String state);


    //Write a derived query to list all accounts with age lower than or equal to a specific value

 List<Account> findAccountByAgeIsLessThanEqual(int age);
    //Write a derived query to list all accounts with a specific role

 List<Account> findAccountByRoleEquals( UserRole userRole);

 // List<Account> findByRole (UserRole userRole);
    //List<Account> findAllByRole(UserRole role);
    //Write a derived query to list all accounts between a range of ages

   List<Account> findAccountByAgeBetween(int age, int age2);
    //Write a derived query to list all accounts where the beginning of the address contains the keyword

List<Account> findAccountByAddressStartingWith(int a);
//List<Account> findByAddressStartingWith(String keyword);
    //Write a derived query to sort the list of accounts with age
  List<Account> getAccountByAgeIsNotNullOrderByAge();
  List<Account> findByOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
@Query ("SELECT e from Account e")
List <Account> AllAccounts();

    //Write a JPQL query to list all admin accounts
@Query("SELECT e from Account e where e.role =?1")
    List <Account> AllAdminAccounts(UserRole userRole);

    //Write a JPQL query to sort all accounts with age
@Query("SELECT e from Account e ORDER BY e.age")
List<Account> AccountsSortedByAge();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value="SELECT * from account_details where age<?1", nativeQuery = true)
    List<Account> AgeLowerThanThis(int age);


    //Write a native query to read all accounts that a specific value can be containable in the name,
    // address, country, state city

@Query(value = "SELECT * from Account where Account Like  ?1", nativeQuery = true)
  List<Account> listofAccountsWithContained(String str);

    //Write a native query to read all accounts with an age higher than a specific value

@Query(value="SELECT * from Account where account_age >?1",nativeQuery = true)
    List<Account> listOfAccountsWithAnAgeAbove(int age);
}

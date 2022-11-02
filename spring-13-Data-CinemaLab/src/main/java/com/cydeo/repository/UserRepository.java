package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    Optional<User> findByEmail(String email);

    //Write a derived query to read a user with a username?

    User findByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?

    List<User> findAllByAccountNameContaining (String str);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByAccount_NameContainingIgnoreCase(String str);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findByAccount_AgeGreaterThan(int age);



    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?

    @Query("select u from User u where u.email =?1 ")
    Optional<User> fetchByEmailJPQL(@Param("email") String email);
    //Write a JPQL query that returns a user read by username?

    @Query("select u from User u where u.username=?1")
    Optional<User> fetchByUsernameJPQL(@Param("username") String username);

    //Write a JPQL query that returns all users?

    @Query("SELECT u from User u")
    List<User> fetchAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    @Query(value = "SELECT * from user_account u JOIN account_details_id ad ON " +
            "ad.id=u.account_details_id where ad.name ILIKE concat ('%', ?1,'%')", nativeQuery = true)
    List<User> retrieveAllByName(@Param("name") String name);

    //Write a native query that returns all users?
    @Query(value = "SELECT * from user_account", nativeQuery = true)
    List<User> AllUsers();

    //Write a native query that returns all users in the range of ages?

    @Query(value = "SELECT * from user_account ua " +
            "JOIN account_details_id ad ON ad.id =u.account_details_id where ad.age between ?1 and ?2", nativeQuery = true)
    List<User> UsersBetweenAgeRange(@Param("age1") Integer age1, @Param("age2") Integer age2);

    //Write a native query to read a user by email?

    @Query(value="select * from USER where email =?1  ", nativeQuery = true)
    User findByEmailNative(@Param ("email") String email);

}

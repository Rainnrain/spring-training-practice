package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought

    Integer countAllByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);


    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);

    //Write a derived query to list all tickets between a range of dates
List<Ticket> findAllByDateTimeBetween(LocalDateTime a, LocalDateTime b);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
@Query("Select t FROM Ticket t where t.userAccount.id =?1")
    List<Ticket> fetchAllTicktesByUserAccount(@Param("userId") Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
@Query("select t from Ticket t where t.dateTime between ?1 And ?2")
    List<Ticket> fetchAllTicktsBetweenRangeOfDates(@Param("DateTime1") LocalDateTime a, @Param("DateTime2") LocalDateTime b);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value="SELECT count(*) from ticket where user_account_id=?1", nativeQuery = true)
    Integer countAllTicketsByUserAccount(@Param("UserId") Long userId);
    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT count(*) from ticket where user_account_id =?1 AND date_time between ?2 AND ?3", nativeQuery = true)
    Integer numberOfTicketsBought(@Param("accountId") Long userId, @Param("DateTime") LocalDateTime a,@Param("DateTime") LocalDateTime b );

    //Write a native query to distinct all tickets by movie name

    @Query(value="select distinct (m.name) from ticket t JOIN movie_cinema mc ON mc.id= t.movie_cinema_id" +
            "JOIN movie_m ON m.id =mc.movie_id", nativeQuery = true)
    List<String> namesOfMovies();


    //Write a native query to find all tickets by user email

    @Query(value="SELECT * from ticket t JOIN user_account ua ON t.user_account_id =ua.id" +
            "where ua.email=?1", nativeQuery = true)
    List<Ticket> findAllByUserEmail(@Param("email") String email);

    //Write a native query that returns all tickets

    @Query(value="", nativeQuery = true)
    List<Ticket> retrieveAll();

    //Write a native query to list all tickets where a specific value should be
    // containable in the username or account name or movie name
//
//
//    @Query(value="SELECT * from tickets t  join user_account ua ON t.user_account_id = ua.id" +
//            "JOIN account_details ad ON ad.id=ua.account_details_id" +
//            "JOIN movie_cinema mc ON mc.id=t.movie_cinema_id" +
//            "JOIN Movie m ON mc.movie_id=m.id" +
//            "Where ua.username ILIKE concat ('%', ?1,'%') ", nativeQuery = true)
//    List<Ticket> specificTickets(@Param("key") String username);
//














    @Query(value="SELECT * from ticket t  JOIN user_account ua ON t.user_account_id=ua.id" +
            "JOIN account_details ad ON ad.id=ua.account_details_id" +
            "JOIN movie_cinema mc on mc.id=t.movie_cinema_id" +
            "JOIN movie m ON mc.movie_id=m.id" +
            "Where ua.username ILIKE concat('%',?1,'%')" +
            "Or ad.name ILIKE concat ('%',?1,'%')" +
            "or m.name ILIKE concat ('%',?1,'%')", nativeQuery = true)
    List<Ticket> ticktesWithUserAccount(@Param ("user") String userName);


}

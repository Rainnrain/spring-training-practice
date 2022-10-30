package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    List<Cinema> findCinemaByNameEquals(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

    List<Cinema> findTop3ByNameContains(String name);


    //Write a derived query to list all cinemas in a specific country
List<Cinema> findCinemaByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
List<Cinema> findCinemaByNameContainsOrSponsoredNameContains(String str, String str2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c from Cinema c where c.id =?1 ")
    Cinema cinemaWithASpecificId(Long id);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(nativeQuery = true, value = "select * from cinema right join location l on l.country = ?1")
List<Cinema> findByLocation(String location);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
@Query(nativeQuery = true, value = "select * from cinema Where name =?1 Or sponsored_name=?1")
List<Cinema> findByNameOrSponsorName(String name);

    //Write a native query to sort all cinemas by name
@Query(nativeQuery = true, value = "select * from Cinema order by name ")
    List<Cinema> sortedByName();

    //Write a native query to distinct all cinemas by sponsored name
   @Query(nativeQuery = true, value = "select distinct sponsored_name from cinema") //  Not sure if this is what the question is asking

   List<String> distinctSponsores();
}
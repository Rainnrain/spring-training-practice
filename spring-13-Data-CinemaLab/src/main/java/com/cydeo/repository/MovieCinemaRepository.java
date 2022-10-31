package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id


    MovieCinema findMovieCinemaByid(Long aLong);


    //Write a derived query to count all movie cinemas with a specific cinema id
    int countByCinema_id(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id

    int countMovieCinemaByMovie_id(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findMovieCinemaByDateTimeAfter(LocalDateTime x);


    //Write a derived query to find the top 3 expensive movies

  //  List<MovieCinema>  ();
    //Not working
    //Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findMovieCinemaByMovie_Name(String movie);
    //Write a derived query to list all movie cinemas in a specific location name


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query( "SELECT a from MovieCinema a where a.dateTime > ?1")
    List<MovieCinema> listOfMovieCinemasAfterDate(LocalDateTime date);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
@Query(value = "SELECT count whe",nativeQuery = true)
    int countOfCinemaMovies();

    //Write a native query that returns all movie cinemas by location name
@Query(value="SELECT * from movieCinema where movieCinema.cinema.location =?1",nativeQuery = true)
List<MovieCinema> findByName(@Param("Pattern") String location);
}

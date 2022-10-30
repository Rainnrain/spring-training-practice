package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres

   List<Genre> findAll();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
@Query(value="select name from genre",nativeQuery = true)
   List<String> genreNames();

   @Query(value="select name from genre where name like ?1",nativeQuery = true)
   List<String> genreNames2(String name);

}

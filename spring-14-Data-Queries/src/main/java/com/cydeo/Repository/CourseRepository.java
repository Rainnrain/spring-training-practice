package com.cydeo.Repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //Find all courses by category

    List<Course> findByCategory (String category);
    List<Course> findByCategoryOrderByName(String category);
//CHeck if a course with the supplied name exists. Return true if exits

    boolean existsByCategory(String category);

    // Returns the count of courses for the given category

    int countByCategory(String category);

    //Find all the courses that start with the given course name String

    List<Course> findByNameStartingWith (String name);

    //Find all courses by category and returns a stream

    Stream<Course> streamAllByCategory(String category);



    @Query("SELECT c from Course c Where c.category = :category AND " +
            "c.rating>:rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(
            @Param("category") String category, @Param("rating") int rating);

}

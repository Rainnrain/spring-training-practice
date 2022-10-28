package com.cydeo.Repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository <Department,String> {

// Display all the departments in the furniture department

    List<Department> findByDepartment(String department);


    // Display all the departments in the health division

    List<Department> findByDivision(String division);

    List<Department> findByDivisionIs (String division); // Same as above method

    List<Department> findByDivisionEquals(String division); // same as above

    // Display all departments with division name ending with 'ics'

    List<Department> findByDivisionEndingWithIgnoreCase(String str);

    //Display the top 3 departments with division name including "Hea" without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String str);


    @Query("Select d from Department d WHERE  d.division IN ?1")
    List<Department> retrieveDepartmentDivision(List<String> division);

    //

}

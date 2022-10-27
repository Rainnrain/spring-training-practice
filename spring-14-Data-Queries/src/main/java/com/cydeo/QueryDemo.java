package com.cydeo;

import com.cydeo.Repository.DepartmentRepository;
import com.cydeo.Repository.EmployeeRepository;
import com.cydeo.Repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("FindByCountry:"+regionRepository.findByCountry("Canada"));
        System.out.println("FindByCountry:"+regionRepository.findByCountryContaining("United"));
        System.out.println("FindByCountry:"+regionRepository.findByCountryContainingOrderByRegion("United"));
        System.out.println("FindByCountry:"+regionRepository.findTop2ByCountry("United States"));
        System.out.println("FindByCountry:"+regionRepository.findByCountryContainingOrderByRegion("United States"));

        System.out.println("------------Department--------------");
        System.out.println("FindByDepartment"+ departmentRepository.findByDepartment("Furniture"));
        System.out.println("FindByDepartment"+ departmentRepository.findByDivision("Health"));
        System.out.println("FindByDepartment"+ departmentRepository.findByDivisionEndingWithIgnoreCase("ics"));
        System.out.println("FindByDepartment"+ departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("------------------Employees--------------");
        System.out.println("Employee "+employeeRepository.retrieveEmployeeDetail());
        System.out.println("Employee "+employeeRepository.retrieveEmployeeSalary());
    }
}

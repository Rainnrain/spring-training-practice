package com.cydeo;

import com.cydeo.Repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;

    public QueryDemo(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("FindByCountry:"+regionRepository.findByCountry("Canada"));
        System.out.println("FindByCountry:"+regionRepository.findByCountryContaining("United"));
        System.out.println("FindByCountry:"+regionRepository.findByCountryContainingOrderByRegion("United"));

    }
}

package com.cydeo;

import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueriesDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;


    public QueriesDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository) {
        this.accountRepository = accountRepository;

        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating my tests");
        System.out.println("Account test: "+accountRepository.findAccountByCountryEqualsOrState("United States", "New York"));
        System.out.println("Account test: "+accountRepository.findAccountByAgeIsLessThanEqual(36));
        System.out.println("Account test: "+accountRepository.findAccountByRoleEquals(UserRole.USER));
        System.out.println("Account test: "+accountRepository.findAccountByAgeBetween(24, 56));
        System.out.println("Account address: "+accountRepository.findAccountByAddressStartingWith(4));
        System.out.println("Account test: "+accountRepository.getAccountByAgeIsNotNullOrderByAge());
        System.out.println("JPA TEST "+accountRepository.AllAccounts());
        System.out.println("Admin Accounts "+ accountRepository.AllAdminAccounts(UserRole.ADMIN));
        System.out.println("Sorted By age "+accountRepository.AccountsSortedByAge());
        System.out.println("Sorted By age "+accountRepository.AgeLowerThanThis(37));
        System.out.println("--------------Cinema--------------");
        System.out.println("Cinema "+ cinemaRepository.findCinemaByNameEquals("Hall 3 - EMPIRE"));
        System.out.println("Cinema "+ cinemaRepository.findTop3ByNameContains("EMPIRE"));
        System.out.println("Cinema "+ cinemaRepository.findCinemaByLocation_Country("United States"));
        System.out.println("Cinema "+ cinemaRepository.findCinemaByNameContainsOrSponsoredNameContains("Village", "Du Pont"));
        System.out.println("Cinema by Id "+ cinemaRepository.cinemaWithASpecificId(1L));
        System.out.println("CinemaByLocation Native "+cinemaRepository.findByLocation("United States"));
        System.out.println("Cinema By Name or sponsor: "+cinemaRepository.findByNameOrSponsorName("HBO"));
        System.out.println("OrderedByName: "+cinemaRepository.sortedByName());
        System.out.println("distinct Sponsor "+cinemaRepository.distinctSponsores());

    }
}

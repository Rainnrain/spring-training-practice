package com.cydeo;

import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class QueriesDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;

    private final GenreRepository genreRepository;

    private final MovieCinemaRepository movieCinemaRepository;


    public QueriesDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository) {
        this.accountRepository = accountRepository;

        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating my tests");
        System.out.println("Account test: "+accountRepository.findAccountByCountryOrState("United States", "New York"));
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

        System.out.println("-----------_----Genre--------------");
        System.out.println("Genre: "+genreRepository.findAll());
        System.out.println("genre Native: "+genreRepository.genreNames());
        System.out.println("Genre: "+genreRepository.genreNames2("Drama"));

        System.out.println("-----------_----Movie Cinema--------------");
        System.out.println("Movie: "+movieCinemaRepository.findMovieCinemaByid(2L));
        System.out.println("Movie: "+movieCinemaRepository.countByCinema_id(1L));
        System.out.println("Movie: "+movieCinemaRepository.countMovieCinemaByMovie_id(2L));
        System.out.println("Movie: "+movieCinemaRepository.findMovieCinemaByDateTimeAfter(LocalDateTime.of(2020,12,06,12,00)));
      // System.out.println("Movie: "+movieCinemaRepository.findMovieCinemasOrderByMovie_Price());
        System.out.println("Movie by name: "+movieCinemaRepository.findMovieCinemaByMovie_Name("Tenet"));


    }
}

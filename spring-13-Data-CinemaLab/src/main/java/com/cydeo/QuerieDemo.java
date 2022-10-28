package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QuerieDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;


    public QuerieDemo(AccountRepository accountRepository  ) {
        this.accountRepository = accountRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating my tests");
      System.out.println("Account test: "+accountRepository.findByAddress("262  Lochmere Lane"));
     //   System.out.println("Account test: "+accountRepository.findAccountByAgeIsLessThanEqual(24));
     //   System.out.println("Account test: "+accountRepository.findAccountByRoleEquals(UserRole.ADMIN));
     //   System.out.println("Account test: "+accountRepository.findAccountByAgeBetween(24, 56));
       // System.out.println("Account test: "+accountRepository.findByAgeOrderByAge());
    }
}

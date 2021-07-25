package com.example.demo.login.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.login.repository.RoleRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(RoleRepository repository) {

    return args -> {
    //  log.info("Preloading " + repository.save(new Role(ERole.ROLE_ADMIN)));
    //  log.info("Preloading " + repository.save(new Role(ERole.ROLE_DONOR)));
    //  log.info("Preloading " + repository.save(new Role(ERole.ROLE_PATIENT)));
    //  log.info("Preloading " + repository.save(new Role(ERole.ROLE_STUDENT)));
    };
  }
}
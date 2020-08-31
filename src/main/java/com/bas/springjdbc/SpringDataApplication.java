package com.bas.springjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonSpringDataRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All persons " + repo.findAll());
        logger.info("User id 10001 -> {}", repo.findById(10001));
        logger.info("Insert id 10004" + repo.save(
                new Person("Bas","Auckland")
        ));
        logger.info("Update id 10003" + repo.save(
                new Person(10003, "Pieter","Utrecht")
        ));
        repo.deleteById(10001);
        logger.info("All persons " + repo.findAll());

    }
}


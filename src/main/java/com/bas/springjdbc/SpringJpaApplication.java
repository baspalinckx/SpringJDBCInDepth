package com.bas.springjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonJpaRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All persons " + repo.findAll());
        logger.info("User id 10001 -> {}", repo.findById(10001));
        logger.info("Insert id 10004" + repo.insert(
                new Person("Bas","Auckland")
        ));
        logger.info("Update id 10003" + repo.update(
                new Person(10003, "Pieter","Utrecht")
        ));
        repo.deleteById(10001);
        logger.info("All persons " + repo.findAll());

    }
}


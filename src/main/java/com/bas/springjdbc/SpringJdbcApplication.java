package com.bas.springjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonJdbcDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All persons " + dao.findAll());
        logger.info("User id 10001" + dao.findById(10001));
        logger.info("Deleted id 10001, number of rows " + dao.deleteById(10002));
        logger.info("Insert id 10004, number of rows " + dao.insert(
                new Person(10004, "Bas","Auckland")
        ));
        logger.info("Update id 10003, number of rows " + dao.update(
                new Person(10003, "Pieter","Utrecht")
        ));
        logger.info("All persons " + dao.findAll());

    }
}

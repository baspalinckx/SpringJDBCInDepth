package com.bas.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //example RowMapper
    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setName(resultSet.getString("name"));
            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class))
                // new PersonRowMapper());
        ;
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?",
                new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (ID, NAME, LOCATION) " +
                "values(?, ?, ?)",
                new Object[]{person.getId(), person.getName(), person.getLocation()});
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ? " +
                "where id = ?",
                new Object[]{person.getName(), person.getLocation(), person.getId()});
    }
}

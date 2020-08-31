package com.bas.springjdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepo {

    //connect to the database
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> nameQuery =
                entityManager.createNamedQuery("find_all_persons", Person.class);
        return nameQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);//JPA
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    //same as update funny enough
    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}

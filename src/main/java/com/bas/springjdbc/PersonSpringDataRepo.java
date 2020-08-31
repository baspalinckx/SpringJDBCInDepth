package com.bas.springjdbc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepo extends JpaRepository<Person, Integer> {
}

package com.hcltech.springstructure.repository;

import com.hcltech.springstructure.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

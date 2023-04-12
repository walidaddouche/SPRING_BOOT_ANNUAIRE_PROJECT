package com.example.demo.repository;

import com.example.demo.model.GroupTable;
import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    List<Person> findByFirstName(String firstName);

    Optional<Person> findByLastNameAndFirstNameIgnoreCase(String lastName , String firstName);

    Optional<Person> findByLastNameAndFirstName(String lastName , String firstName);

    List<Person> findByLastNameIgnoreCase(String LastName);

    Optional<Person> findByEmail(String email);

    void deleteByEmail(String email);

    long countPersonsByGroup(GroupTable group);

    List<Person> findByGroup(GroupTable groupTable);


}
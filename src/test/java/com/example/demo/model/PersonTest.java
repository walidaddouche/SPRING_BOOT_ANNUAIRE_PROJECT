package com.example.demo.model;

import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.List;

@DataJpaTest
class PersonTest {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testPersonTable() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("johndoe@example.com");
        person.setDateOfBirth(new Date());
        person.setPassword("password");

        entityManager.persist(person);
        entityManager.flush();

        List<Person> found = personRepository.findByFirstName("John");
        Integer integer = found.size();

        Assertions.assertEquals("John", found.get(0).getFirstName());
    }

}
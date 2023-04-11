package com.example.demo.repository;

import com.example.demo.model.Person;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest // Utilisation d'une base de données en mémoire pour les tests
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // Recharge la base de données avant chaque test
public class PersonRepoTest {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void savePerson() {
        // Création d'une personne
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("john.doe@example.com");
        person.setPassword("password");

        // Enregistrement de la personne dans la base de données
        Person savedPerson = personRepo.save(person);

        // Vérification que la personne a bien été enregistrée
        assertThat(savedPerson.getId()).isNotNull();
        assertThat(savedPerson.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(savedPerson.getLastName()).isEqualTo(person.getLastName());
        assertThat(savedPerson.getEmail()).isEqualTo(person.getEmail());
        assertThat(savedPerson.getPassword()).isEqualTo(person.getPassword());
    }

    @Test
    public void findPersonById() {
        // Création d'une personne
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("john.doe@example.com");
        person.setPassword("password");

        // Enregistrement de la personne dans la base de données
        Person savedPerson = entityManager.persistAndFlush(person);

        // Récupération de la personne à partir de son ID
        Person foundPerson = personRepo.findById(savedPerson.getId()).orElse(null);

        // Vérification que la personne a bien été trouvée
        assertThat(foundPerson).isNotNull();
        assertThat(foundPerson.getId()).isEqualTo(savedPerson.getId());
        assertThat(foundPerson.getFirstName()).isEqualTo(savedPerson.getFirstName());
        assertThat(foundPerson.getLastName()).isEqualTo(savedPerson.getLastName());
        assertThat(foundPerson.getEmail()).isEqualTo(savedPerson.getEmail());
        assertThat(foundPerson.getPassword()).isEqualTo(savedPerson.getPassword());
    }
    @Test
    public void testFindByLastName() {
        Person person1 = new Person();

        person1.setFirstName("john");
        person1.setFirstName("Doe");
        person1.setEmail("johndoe@test.com");
        person1.setPassword("password");
        personRepo.save(person1);


        Person person2 = new Person();
        person2.setFirstName("jan");
        person2.setFirstName("Doe");
        person2.setEmail("jandoe@test.com");
        person2.setPassword("password");
        personRepo.save(person2);

        var result = personRepo.findByFirstName("Doe");

        assertEquals(2, result.size());
        assertTrue(result.contains(person1));
        assertTrue(result.contains(person2));
    }


        @Test
        public void testFindByEmail() {

            Person person1 = new Person();
            person1.setFirstName("john");
            person1.setFirstName("Doe");
            person1.setEmail("johndoe@test.com");
            person1.setPassword("password");
            personRepo.save(person1);


            Person person2 = new Person();
            person2.setFirstName("jan");
            person2.setFirstName("Doe");
            person2.setEmail("janDoe@test.com");
            person2.setPassword("password");

            var result = personRepo.findByEmail("johndoe@test.com");

            Assertions.assertTrue(result.isPresent());
        }

        @Test
        public void testDeleteByEmail() {
            Person person = new Person();
            person.setFirstName("john");
            person.setFirstName("Doe");
            person.setEmail("johndoe@test.com");
            person.setPassword("password");
            personRepo.save(person);

            personRepo.deleteByEmail("johndoe@test.com");

            Optional<Person> result = personRepo.findByEmail("johndoe@test.com");
            Assertions.assertFalse(result.isPresent());
        }

        @Test
        public void testFindByLastNameIgnoreCase() {
            Person person1 = new Person();
            person1.setFirstName("john");
            person1.setLastName("Doe");
            person1.setEmail("johndoe@test.com");
            person1.setPassword("password");
            personRepo.save(person1);



            Person person2 = new Person();
            person2.setFirstName("jan");
            person2.setLastName("Doe");
            person2.setEmail("janndoe@test.com");
            person2.setPassword("password");
            personRepo.save(person2);

            List<Person> result = personRepo.findByLastNameIgnoreCase("DOE");

            Assertions.assertEquals(2, result.size());
            assertTrue(result.contains(person1));
            assertTrue(result.contains(person2));
        }




    @Test
    public void testFindByLastNameAndFirstName() {
        Person person = new Person();
        person.setFirstName("john");
        person.setLastName("Doe");
        person.setEmail("johndoe@test.com");
        person.setPassword("password");
        personRepo.save(person);

        Optional<Person> result = personRepo.findByLastNameAndFirstName("Doe", "john");

        assertTrue(result.isPresent());
        assertEquals(person, result.get());
    }




}

package com.example.demo;



import com.example.demo.model.GroupTable;
import com.example.demo.model.Person;
import com.example.demo.repository.GroupTableRepository;
import com.example.demo.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.aspectj.weaver.Iterators;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.ITERATOR;

@SpringBootTest
@ActiveProfiles("test")
public class testFakesData {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GroupTableRepository groupRepository;

    Faker faker = new Faker();


    @Test
    public void testFaker() {
        List<GroupTable> groups = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            GroupTable group = new GroupTable();
            group.setName(faker.company().name());
            groupRepository.save(group);
            groups.add(group);
        }

        for (int i = 0; i < 11; i++) {
            Person person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setEmail(faker.internet().emailAddress());
            person.setWebsite(faker.internet().url());
            person.setDateOfBirth(faker.date().birthday());
            person.setPassword(faker.internet().password());
            person.setGroup(groups.get(faker.random().nextInt(groups.size())));
            personRepository.save(person);
        }
    }


    @Test
    void testUpdateAll(){

        Person person = new Person();

        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        person.setEmail(faker.internet().emailAddress());
        person.setWebsite(faker.internet().url());
        person.setDateOfBirth(faker.date().birthday());
        person.setPassword(faker.internet().password());
        personRepository.save(person);


        Person person1 = new Person();

        person1.setFirstName(faker.name().firstName());
        person1.setLastName(faker.name().lastName());
        person1.setEmail(faker.internet().emailAddress());
        person1.setWebsite(faker.internet().url());
        person1.setDateOfBirth(faker.date().birthday());
        person1.setPassword(faker.internet().password());
        personRepository.save(person1);




    }
}

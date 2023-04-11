package com.example.demo;



import com.example.demo.model.GroupTable;
import com.example.demo.model.Person;
import com.example.demo.repository.GroupTableRepository;
import com.example.demo.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class testFakesData {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GroupTableRepository groupRepository;

    @Test
    public void testFaker() {
        Faker faker = new Faker();
        List<GroupTable> groups = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            GroupTable group = new GroupTable();
            group.setName(faker.company().name());
            groupRepository.save(group);
            groups.add(group);
        }

        for (int i = 0; i < 10; i++) {
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


        groups.forEach(group -> System.out.println(personRepository.countPersonsByGroup(group)));

        assertThat(personRepository.count()).isEqualTo(10);
        assertThat(groupRepository.count()).isEqualTo(5);
    }
}

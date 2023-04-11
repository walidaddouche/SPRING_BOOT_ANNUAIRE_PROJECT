package com.example.demo;

import com.example.demo.model.GenearatorUtility;
import com.example.demo.model.Generator;
import com.example.demo.model.GroupTable;
import com.example.demo.model.Person;
import com.example.demo.repository.GroupTableRepository;
import com.example.demo.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication {



    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        GroupTableRepository groupRepository = context.getBean(GroupTableRepository.class);

        Faker faker = new Faker();
        List<GroupTable> groups = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            GroupTable group = new GroupTable();
            group.setName(faker.team().name());
            groupRepository.save(group);
            groups.add(group);

        }



        for (int i = 0; i < 1000; i++) {
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

}
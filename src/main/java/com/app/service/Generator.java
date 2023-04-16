package com.app.service;

import com.app.model.GroupTable;
import com.app.model.Person;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Generator {


    private final Faker faker;

    public Generator(Faker faker) {
        this.faker = faker;
    }

    public List<Person> generatePersons(int count, List<GroupTable> groups) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Person person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setEmail(faker.internet().emailAddress());
            person.setWebsite(faker.internet().url());
            person.setDateOfBirth(faker.date().birthday());
            person.setPassword(faker.internet().password());
            person.setGroup(randomGroup(groups));
            people.add(person);
        }
        return people;
    }

    public List<GroupTable> generateGroups(int count) {
        List<GroupTable> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            GroupTable group = new GroupTable();
            group.setName(faker.company().name());
            groups.add(group);
        }
        return groups;
    }

    private GroupTable randomGroup(List<GroupTable> groups) {
        int index = faker.random().nextInt(groups.size());
        return groups.get(index);
    }








}

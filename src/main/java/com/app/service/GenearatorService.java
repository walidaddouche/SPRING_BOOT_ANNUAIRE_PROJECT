package com.app.service;

import com.app.model.Person;
import com.app.repository.GroupTableRepository;
import com.app.model.GroupTable;
import com.app.repository.PersonRepository;
import lombok.Data;

import java.util.List;


@Data
public class GenearatorService {

    private final Generator generator;
    private final GroupTableRepository groupRepository;
    private final PersonRepository personRepository;




    public void generateData() {
        List<GroupTable> groups = generator.generateGroups(400);
        groupRepository.saveAll(groups);

        List<Person> people = generator.generatePersons(1000, groups);
        personRepository.saveAll(people);
    }
}

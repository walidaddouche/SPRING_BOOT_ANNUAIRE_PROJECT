package com.example.demo.model;

import com.example.demo.repository.GroupTableRepository;
import com.example.demo.repository.PersonRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class GenearatorUtility {

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

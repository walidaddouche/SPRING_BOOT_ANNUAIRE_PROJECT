package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	    PersonRepository personRepository = context.getBean(PersonRepository.class);
        Faker faker = new Faker();
        for (int i = 0; i < 1000; i++) {
            Person person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setEmail(faker.internet().emailAddress());
            person.setWebsite(faker.internet().url());
            person.setDateOfBirth(faker.date().birthday());
            person.setPassword(faker.internet().password());
            personRepository.save(person);
        }

    }

}

package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.example.controller.")
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	    PersonRepository personRepository = context.getBean(PersonRepository.class);
        Person myPerson = new Person();
        myPerson.setFirstName("walid");
        myPerson.setLastName("add");
        myPerson.setEmail("walid.ad93@gmail.col");
        myPerson.setPassword("walid.ad93@gmail.col");

        personRepository.save(myPerson);
    }

}

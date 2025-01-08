package com.example.dbconnectionproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Person;

import repository.PersonRepository;

@SpringBootApplication
public class DbConnectionProjectApplication {
    
    public static void main(String[]args) {
        SpringApplication.run(DbConnectionProjectApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return args -> {
            Person person1 = new Person();
            person1.setName("John Doe");
            person1.setAge(25);
            personRepository.save(person1);
            
            Person person2 = new Person();
            person2.setName("Jane Smith");
            person2.setAge(30);
            personRepository.save(person2);
            
            Long personId = 1L;
            Person retrievedPerson = personRepository.findById(personId).orElse(null);
            
            if (retrievedPerson != null) {
                System.out.println("Retrieved Person: " + retrievedPerson.getName() + " (Age: " + retrievedPerson.getAge() + ")");
            } else {
                System.out.println("Person not found with ID: " + personId);
            }
        };
    }
}

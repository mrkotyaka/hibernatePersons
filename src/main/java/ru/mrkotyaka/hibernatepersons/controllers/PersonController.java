package ru.mrkotyaka.hibernatepersons.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mrkotyaka.hibernatepersons.entities.Person;
import ru.mrkotyaka.hibernatepersons.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCityOfLiving(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/persons/less-age")
    public List<Person> getPersonsThatAgeLessThanAndSortedByAge(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<List<Person>> getPersonByNameAndSurname(@RequestParam String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}

package ru.mrkotyaka.hibernatepersons.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mrkotyaka.hibernatepersons.entities.Person;
import ru.mrkotyaka.hibernatepersons.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCityOfLiving(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/less-age")
    public List<Person> getPersonsThatAgeLessThanAndSortedByAge(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<List<Person>> getPersonByNameAndSurname(@RequestParam String name, String surname) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());

        return personRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping("/getmyname")
    public String getMyName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String name = userDetails.getUsername();

        System.out.println("Your login is: " + name);
        return "Your login is: " + name;
    }
}

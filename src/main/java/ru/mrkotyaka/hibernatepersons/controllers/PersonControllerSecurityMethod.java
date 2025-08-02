package ru.mrkotyaka.hibernatepersons.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mrkotyaka.hibernatepersons.entities.Person;
import ru.mrkotyaka.hibernatepersons.repositories.PersonRepository;
import ru.mrkotyaka.hibernatepersons.services.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secured_methods")
public class PersonControllerSecurityMethod {

    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonControllerSecurityMethod(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping("/{username}/greetings")
    public String getGreetingsUserSM(@PathVariable String username) {
        return personService.greetingUserSM(username);
    }

    @GetMapping("/city/{city}")
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    public List<Person> getPersonsByCityOfLivingSM(@PathVariable String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/age/{age}")
    @RolesAllowed("READ")
    public List<Person> getPersonsThatAgeLessThanAndSortedByAgeSM(@PathVariable int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    @DeleteMapping("/delete/{id}")
    @Secured("ROLE_DELETE")
//    @RolesAllowed("ROLE_DELETE")
    public String deletePersonSM(@PathVariable int id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.delete(person.get());
            return "Deleted person with id: " + id;
        } else {
            System.out.println("Person with id " + id + " not found");
            return "Person with id " + id + " not found";
        }
    }
}

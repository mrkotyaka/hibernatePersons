package ru.mrkotyaka.hibernatepersons.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mrkotyaka.hibernatepersons.entities.Person;
import ru.mrkotyaka.hibernatepersons.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secured_methods")
public class PersonControllerSecurityMethod {

    private final PersonRepository personRepository;

    public PersonControllerSecurityMethod(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/greetings")
    @PreAuthorize("#username == authentication.principal.username")
    public ResponseEntity<?> getGreetingsUserSM(@RequestParam String username) {
        return ResponseEntity.ok("Greetings, my younger java developer, " + username);
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

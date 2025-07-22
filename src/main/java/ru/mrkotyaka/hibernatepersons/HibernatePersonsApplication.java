package ru.mrkotyaka.hibernatepersons;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import ru.mrkotyaka.hibernatepersons.entities.Person;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernatePersonsApplication implements CommandLineRunner {

    @PersistenceContext
    EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(HibernatePersonsApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {

        List<Person> pers = new ArrayList<>();
        pers.add(Person.builder()
                .name("John")
                .surname("Snow")
                .city_of_living("Moscow")
                .age(38)
                .phone_number("987654321").build());
        pers.add(Person.builder()
                .name("Sam")
                .surname("Rockwell")
                .city_of_living("Moscow")
                .age(44)
                .phone_number("123456789").build());
        pers.forEach(persons -> em.persist(persons));
    }
}

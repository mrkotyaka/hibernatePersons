package ru.mrkotyaka.hibernatepersons;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernatePersonsApplication {

    @PersistenceContext
    EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(HibernatePersonsApplication.class, args);
    }
}

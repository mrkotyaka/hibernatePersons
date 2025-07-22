package ru.mrkotyaka.hibernatepersons.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.mrkotyaka.hibernatepersons.entities.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Person> getPersonsByCity(String city) {
        Query query = em.createQuery("select p from Person p where p.city_of_living = :city");
        query.setParameter("city", city);
        return (List<Person>) query.getResultList();
    }
}

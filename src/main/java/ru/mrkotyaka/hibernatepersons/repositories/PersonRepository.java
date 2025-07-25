package ru.mrkotyaka.hibernatepersons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mrkotyaka.hibernatepersons.entities.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("select p from Person p where p.age < :age order by p.age")
    List<Person> findByAgeLessThanOrderByAge(@Param("age") int age);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<List<Person>> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}

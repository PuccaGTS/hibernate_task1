package ru.netology.netolhiber1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.netolhiber1.entity.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonByCity(String city){
        String query = "SELECT person from Person person where person.city = ?1";
        return entityManager.createQuery(query)
                .setParameter(1, city)
                .getResultList();
    }
}

package ru.netology.netolhiber1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.netology.netolhiber1.entity.Person;
import ru.netology.netolhiber1.entity.PersonPK;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, PersonPK> {
        public List<Person> getPersonByCity(String city);

        public List<Person> getPersonByAgeBeforeOrderByAge(int age);

        public Optional<Person> getPersonByNameAndSurname (String name, String surname);
}

package ru.netology.netolhiber1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.netology.netolhiber1.entity.Person;
import ru.netology.netolhiber1.entity.PersonPK;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, PersonPK> {
        @Query("select person from Person person where person.city = :city")
        public List<Person> getPersonByCity(@Param("city") String city);

        @Query("select person from Person person where person.age<:age order by person.age")
        public List<Person> getPersonByAgeBeforeOrderByAge(@Param("age") int age);

        @Query("select person from Person person where person.name = :name AND person.surname = :surname")
        public Optional<Person> getPersonByNameAndSurname (@Param("name") String name, @Param("surname") String surname);
}

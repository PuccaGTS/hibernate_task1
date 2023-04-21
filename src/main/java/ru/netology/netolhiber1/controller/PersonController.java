package ru.netology.netolhiber1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netolhiber1.entity.Person;
import ru.netology.netolhiber1.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;
    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(@RequestParam String city){
        return personRepository.getPersonByCity(city);
    }

}
